package com.kolektesan.julio.kolektesan.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.backendless.Backendless;
import com.kolektesan.julio.kolektesan.R;

import static com.kolektesan.julio.kolektesan.util.BackendlessSetting.APP_ID;

public class Splash extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    SharedPreferences prefs ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        Backendless.initApp(this, APP_ID, APP_ID);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (isNetworkAvailable() == true) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkLogStatus();
                }
            }, SPLASH_DISPLAY_LENGTH);
        }else{
            new AlertDialog.Builder(Splash.this)
                    .setTitle("Infos")
                    .setMessage(R.string.nonet)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setIcon(R.drawable.ic_action_error_info)
                    .show();
        }
    }


    public void checkLogStatus() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(prefs.getString("telephone", "none") == "none"){
            Intent i = new Intent(getApplicationContext(), Home.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }else{
            Intent i = new Intent(getApplicationContext(), Home.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
