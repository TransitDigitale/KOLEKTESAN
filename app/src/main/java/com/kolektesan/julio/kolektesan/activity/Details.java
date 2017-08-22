package com.kolektesan.julio.kolektesan.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kolektesan.julio.kolektesan.R;
import com.kolektesan.julio.kolektesan.model.Centre;

public class Details extends AppCompatActivity {
    Button btnFait;
    TextView tvVille, tvAdresse;
    Centre centre;
    ImageView call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Set aba Toolbar to replace the ActionBar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Informations");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnFait = (Button)findViewById(R.id.btnFait);

        tvVille = (TextView) findViewById(R.id.tvVille);
        tvAdresse = (TextView) findViewById(R.id.tvAdresse);
        call = (ImageView) findViewById(R.id.imageView2);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCall(centre.getTrlrphone());
                Toast.makeText(Details.this, "Call " +centre.getTrlrphone(), Toast.LENGTH_SHORT).show();
            }
        });

        btnFait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(Details.this, Profil.class);
                startActivity(i);
            }
        });

        centre =  (Centre) getIntent().getSerializableExtra("details");
        tvVille.setText(centre.getLieu().toString());
        tvAdresse.setText(centre.getTypee().toString());

    }

    public  void onCall(String tel){
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        callIntent.setData(Uri.parse("tel:" + tel));
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }else {
            Toast.makeText(this, "Pas de permisions", Toast.LENGTH_SHORT).show();
        }
        startActivity(callIntent);
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
}
