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

public class Connect extends AppCompatActivity {
    Button btnConnect , btnGoSign;
    EditText telephone , password;
    ProgressDialog progress;
    SharedPreferences prefs ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        Backendless.setUrl( BackendlessSetting.SERVER_URL );
        Backendless.initApp(this, APP_ID, SECRET_KEY);

        setupViews();
        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                functionConnect();
            }
        });
        // btnGoSign = (Button)findViewById(R.id.btnGoSign);
        btnGoSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Connect.this,Login.class);
                startActivity(intent);
            }
        });

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(prefs.getString("telephone", "none") !="none"){
            // Go to Home
            Intent intent = new Intent(Connect.this,Home.class);
            startActivity(intent);
            finish();
        }
    }

    private void setupViews() {
        btnConnect = (Button)findViewById(R.id.btnConnect);
        btnGoSign = (Button)findViewById(R.id.btnGoSign);
        telephone = (EditText) findViewById(R.id.edtTelephone);
        password = (EditText) findViewById(R.id.edtPassword);
    }
    public  void functionConnect(){
        showLoading();
        final String uTel , uPass ;
                uTel =  telephone.getText().toString();
                uPass =  password.getText().toString();

        if ( uTel.equals("") || uPass.equals("") ) {
            new AlertDialog.Builder(Connect.this)
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
            prefs = PreferenceManager.getDefaultSharedPreferences(Connect.this);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("password", uPass);
            editor.putString("telephone", uTel);
            editor.putString("ID_users",uTel);
            editor.commit();
            dimissLoading();
            Intent intent = new Intent(Connect.this,Home.class);
            startActivity(intent);
            finish();
        }
    }
    public void showLoading(){
        progress = ProgressDialog.show(Connect.this, "Connexion","Patientez...",false,false);
    }
    public void dimissLoading(){
        progress.dismiss();
    }
}
