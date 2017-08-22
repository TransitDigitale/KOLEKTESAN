package com.kolektesan.julio.kolektesan.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

public class Progress extends AppCompatActivity {
    ProgressDialog progress;
    public Progress(Context context){
    }
    public void showLoading(){
        progress = ProgressDialog.show(getApplicationContext(), "Connexion","Patientez...",false,false);
    }
    public void dimissLoading(){
        progress.dismiss();
    }

}

