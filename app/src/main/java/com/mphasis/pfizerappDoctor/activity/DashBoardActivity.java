package com.mphasis.pfizerappDoctor.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mphasis.pfizerappDoctor.R;
import com.mphasis.pfizerappDoctor.storage.AppPreferences;
import com.mphasis.pfizerappDoctor.util.Constant;

import java.util.HashMap;



public class DashBoardActivity extends AppCompatActivity {

    private static final String TAG = "PfizerAPP";
    private HashMap<String, String> mKeys;
    private AppPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = new AppPreferences(DashBoardActivity.this);
        TextView userName= (TextView) findViewById(R.id.txt_username);
        String wellcomeUser="Welcome " +pref.getPreferanceData(Constant.PREF_USERNAME);
        userName.setText(wellcomeUser);

        ImageButton userProfileButton= (ImageButton) findViewById(R.id.btn_userProfile);
userProfileButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i = new Intent(DashBoardActivity.this,UserProfileActivity.class);
        startActivity(i);

    }
});

        LinearLayout transaction = (LinearLayout) findViewById(R.id.root_Lin_transaction);
                transaction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(DashBoardActivity.this,TransactionListActivity.class);
                        startActivity(i);

                    }
                });
    }



}
