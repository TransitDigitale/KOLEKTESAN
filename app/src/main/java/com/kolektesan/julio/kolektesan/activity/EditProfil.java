package com.kolektesan.julio.kolektesan.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kolektesan.julio.kolektesan.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class EditProfil extends AppCompatActivity {
    EditText tvGS ,tvAdresse ,
            tvTe ,tvQsang;
    ImageView ivlocal;
    TextView tvVille;
    SharedPreferences prefs ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_profil_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Modifier votre profil");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tvGS = (EditText)findViewById(R.id.tvGS);

        tvVille = (TextView)findViewById(R.id.tvVille);
        tvAdresse = (EditText)findViewById(R.id.tvAdresse);
        tvTe = (EditText)findViewById(R.id.tvTe);
        tvQsang = (EditText)findViewById(R.id.tvQsang);

        ivlocal = (ImageView) findViewById(R.id.ivlocal);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String userName = prefs.getString("name", "n/a");
        String email = prefs.getString("email", "n/a");
        String img = prefs.getString("imageUri","default.png");
        Picasso.with(EditProfil.this).load(img).resize(400 ,400).centerCrop().placeholder(R.drawable.ic_action_person).into(ivlocal);
        //populate info on Drawer
        tvVille.setText(userName);
        findStat();
    }

    public void findStat() {
        String url = "https://shareblood.herokuapp.com/api/users";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    JSONObject jso = new  JSONObject();
                    String name =  jso.getString("name");
                    String phone =  jso.getString("phone");
                    String adresse =  jso.getString("adresse");
                    String qteSang =  jso.getString("qteSang");
                    String blood_type =  jso.getString("blood_type");
                    String photo_url =  response.getString("photo_url");
                    tvVille.setText(name);
                    tvGS.setText(blood_type);
                    tvAdresse.setText(adresse);
                    tvTe.setText(phone);
                    tvQsang.setText(qteSang);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(EditProfil.this, "Error " + errorResponse.toString() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void clickEdit(View view){
        Intent edit = new Intent(EditProfil.this, EditProfil.class);
        startActivity(edit);
        finish();
    }
}
/*
        "id": 1,
        "name": "Alexandre Erich Georges",
        "blood_type": "3",
        "phone": "3479659171",
        "adresse": null,
        "qteSang": null,
        "photo_url": null
*/