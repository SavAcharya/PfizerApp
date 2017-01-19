package com.mphasis.pfizerappDoctor.activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.google.gson.Gson;
import com.mphasis.pfizerappDoctor.R;
import com.mphasis.pfizerappDoctor.adapter.TransactionListAdapter;
import com.mphasis.pfizerappDoctor.model.TransactionListModel;
import com.mphasis.pfizerappDoctor.storage.AppPreferences;
import com.mphasis.pfizerappDoctor.util.Constant;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class TransactionListActivity extends AppCompatActivity {

    String url= "http://54.153.36.202:8008/listaddresstransactions";
    AppPreferences pref;
    private String postData;
    private TransactionListModel transactionList;
    RecyclerView recyclerView;
    private TransactionListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView_transactionList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


pref= new AppPreferences(TransactionListActivity.this);
        new GetTransactionListTask().execute();

    }
    private class GetTransactionListTask extends AsyncTask<URL, Void, Void> {
        final ProgressDialog pDialog = new ProgressDialog(TransactionListActivity.this);
        @Override
        protected void onPreExecute() {
            pDialog.setMessage("Loading...");
            pDialog.show();
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(URL... urls) {
            {

                String response;
                BufferedReader readedr;

                try{

                    URL registerUrl= new URL(url);
                    HttpURLConnection conn = (HttpURLConnection) registerUrl.openConnection();
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                    postData="address="+pref.getPreferanceData(Constant.PREF_ADDRESS); //1STL3VKVt9nXE4gqHQf7s66HCrgsugFg7MhxMq
                   // postData="address=1STL3VKVt9nXE4gqHQf7s66HCrgsugFg7MhxMq";
                    wr.write(postData);
                    wr.flush();
                    readedr = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder sb= new StringBuilder();
                    String data;
                    while ((data = readedr.readLine())!= null){
                        sb.append(data+"\n");
                    }
                    response= sb.toString();
                    Log.i("Register",response);
                    allTransactionList(response);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            pDialog.dismiss();
            mAdapter = new TransactionListAdapter(TransactionListActivity.this,transactionList.getTransactions());
            recyclerView.setAdapter(mAdapter);
            super.onPostExecute(aVoid);
        }
    }

    private void allTransactionList(String response) {
        Gson gson = new Gson();
        transactionList=gson.fromJson(response.toString(),TransactionListModel.class);

        Log.i("Transactions", response.toString());
    }
}
