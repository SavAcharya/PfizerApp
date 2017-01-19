package com.mphasis.pfizerappDoctor.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.google.gson.Gson;
import com.mphasis.pfizerappDoctor.R;
import com.mphasis.pfizerappDoctor.model.RegisterModel;
import com.mphasis.pfizerappDoctor.storage.AppPreferences;
import com.mphasis.pfizerappDoctor.util.Constant;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import static com.mphasis.pfizerappDoctor.util.Constant.BASE_URL;
import static com.mphasis.pfizerappDoctor.util.Constant.REGISTER;

public class SignupActivity extends AppCompatActivity {


    private static final String TAG = "SignupActivity";
    HashMap<String, String> mKeys;
Button register ;
    EditText name;
    String userName;
    String userType="1";
    private RegisterModel registerGSON;
    private TextView mTextView;
    private RequestQueue mRequestQueue;
    private BufferedReader reader;
    private String postData;
    AppPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        pref = new AppPreferences(SignupActivity.this);
        register = (Button) findViewById(R.id.btnRegister);
        name= (EditText) findViewById(R.id.edt_registerName);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               userName= name.getText().toString();
               if ( userName!=null){
                    new DownloadFilesTask().execute();
                }
            }
        });
    }

    private class DownloadFilesTask extends AsyncTask<URL, Void, Void> {
        final ProgressDialog pDialog = new ProgressDialog(SignupActivity.this);
        @Override
        protected void onPreExecute() {
            pDialog.setMessage("Loading...");
            pDialog.show();
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(URL... urls) {
            registerRequest();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            pDialog.dismiss();
            startNextActivity();

            pref.setFirst(false);
            super.onPostExecute(aVoid);
        }
    }

    private void startNextActivity() {
        Intent i = new Intent(SignupActivity.this,DashBoardActivity.class);
        startActivity(i);
        finish();
    }

    private void registerRequest(){
        String url = BASE_URL+REGISTER;
        String response;
        BufferedReader readedr;

        try{

    URL registerUrl= new URL(url);
    HttpURLConnection conn = (HttpURLConnection) registerUrl.openConnection();
    conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
         JSONObject postDataParam =new JSONObject();
            postDataParam.put("type","1");
            postDataParam.put("name","sss");
            postData="type=1&name="+userName;
        wr.write(postData);
        wr.flush();
        readedr = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb= new StringBuilder();
        String data= null;
        while ((data = readedr.readLine())!= null){
        sb.append(data+"\n");
        }
        response= sb.toString();
        Log.i("Register",response);
            showJSON(response);
        } catch(Exception e){
        e.printStackTrace();
        }
        }



    private void showJSON(String response) {
        Gson gson = new Gson();
        registerGSON=gson.fromJson(response.toString(),RegisterModel.class);
        Log.i("Signup", response.toString());
        saveUserData(registerGSON.getAddress(),registerGSON.getPrivateX(),registerGSON.getPublicX());
        }

    private void saveUserData(String address, String privateX, String publicX) {
      pref.addPreferanData(Constant.PREF_ADDRESS,address);
        pref.addPreferanData(Constant.PREF_USERNAME, userName);
        pref.addPreferanData(Constant.PREF_PUBLIC_KEY, publicX);
        pref.addPreferanData(Constant.PREF_PRIVATE_KEY, privateX);

        }

}
