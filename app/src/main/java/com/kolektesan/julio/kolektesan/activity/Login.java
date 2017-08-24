package com.kolektesan.julio.kolektesan.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.backendless.Backendless;
import com.kolektesan.julio.kolektesan.R;
import com.kolektesan.julio.kolektesan.util.BackendlessSetting;

import static com.kolektesan.julio.kolektesan.util.BackendlessSetting.APP_ID;
import static com.kolektesan.julio.kolektesan.util.BackendlessSetting.SECRET_KEY;

public class Login extends AppCompatActivity {
    Button btnLog;
    EditText nom, telephone , password;
    ProgressDialog progress;
    SharedPreferences prefs ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Backendless.setUrl( BackendlessSetting.SERVER_URL );
        Backendless.initApp(this, APP_ID, SECRET_KEY);

        setupViews();
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                functionLogin();
            }
        });
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(prefs.getString("name", "") !=""){
            // Go to Home
            Intent intent = new Intent(Login.this,Home.class);
            startActivity(intent);
        }
    }

    private void setupViews() {
        btnLog = (Button)findViewById(R.id.btnLog);
        nom = (EditText) findViewById(R.id.edtName);
        telephone = (EditText) findViewById(R.id.edtTelephone);
        password = (EditText) findViewById(R.id.edtPassword);
    }
    public  void functionLogin(){
        showLoading();
        final String uNom ,uTel , uPass , uEmail;
                uNom =  nom.getText().toString();
                uTel =  telephone.getText().toString();
                uEmail =  telephone.getText()+"@gmail.com".toString();
                uPass =  password.getText().toString();

        if ( uNom.equals("") || uTel.equals("") || uPass.equals("") ) {
            new AlertDialog.Builder(Login.this)
                    .setTitle("Infos")
                    .setMessage(R.string.champsVides)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        dimissLoading();
                        }
                    })
                    .setIcon(R.drawable.ic_action_error_info)
                    .show();
        }else{
          /*Save users data in a sharepreferences*/
            prefs = PreferenceManager.getDefaultSharedPreferences(Login.this);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("name", uNom);
            editor.putString("email", uEmail);
            editor.putString("telephone", uTel);
            editor.putString("ID_users",uTel);
            editor.commit();
            dimissLoading();
            Intent intent = new Intent(Login.this,Home.class);
            startActivity(intent);
            finish();

        }
    }
    public void showLoading(){
        progress = ProgressDialog.show(Login.this, "Connexion","Patientez...",false,false);
    }
    public void dimissLoading(){
        progress.dismiss();
    }
}
