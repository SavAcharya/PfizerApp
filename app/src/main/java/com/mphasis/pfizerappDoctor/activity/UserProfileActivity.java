package com.mphasis.pfizerappDoctor.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mphasis.pfizerappDoctor.R;
import com.mphasis.pfizerappDoctor.storage.AppPreferences;
import com.mphasis.pfizerappDoctor.util.Constant;
import com.mphasis.pfizerappDoctor.util.Util;

public class UserProfileActivity extends AppCompatActivity {

    AppPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        pref = new AppPreferences(UserProfileActivity.this);

        TextView userName = (TextView) findViewById(R.id.txt_user);
        TextView publicKey = (TextView) findViewById(R.id.txt_publicKey);
        TextView privateKey = (TextView) findViewById(R.id.txt_privateKey);

        userName.setText(pref.getPreferanceData(Constant.PREF_USERNAME));
        publicKey.setText(pref.getPreferanceData(Constant.PREF_PUBLIC_KEY));
        String key= Util.maskPrivateKeyNumber(pref.getPreferanceData(Constant.PREF_PRIVATE_KEY),"####xxxxxxx.....xxxxxx####");

        privateKey.setText(key);
    }
}
