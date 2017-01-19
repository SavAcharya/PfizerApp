package com.mphasis.pfizerappDoctor.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Sourav.Bhattacharya on 1/18/2017.
 */
public class AlertUtility {
    public static void printStatement(String TAG, String message) {
        Log.v(TAG, message);
    }

    public static void showToast( Activity context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Activity context, int message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showAlertDialog(Context context, String title, String message, Boolean status) {
         AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        // Setting Dialog Title
        alertDialog.setTitle(title);

        // Setting Dialog Message
        alertDialog.setMessage(message);

        if(status != null)
            // Setting alert dialog icon
            alertDialog.setIcon((status) ? android.R.drawable.ic_media_play : android.R.drawable.ic_media_pause);

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }

}
