package com.kolektesan.julio.kolektesan.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.backendless.Backendless;
import com.kolektesan.julio.kolektesan.R;
import com.squareup.picasso.Picasso;

import static com.kolektesan.julio.kolektesan.R.id.ivlocal;

public class ProfilDrawerActivity extends AppCompatActivity {
    TextView tvVille;
    ImageView ivlocal;
    SharedPreferences prefs ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_profil_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Profil");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tvVille = (TextView)findViewById(R.id.tvVille);
        ivlocal = (ImageView) findViewById(R.id.ivlocal);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String userName = prefs.getString("name", "n/a");
        String email = prefs.getString("email", "n/a");
        String img = prefs.getString("imageUri","default.png");
        Picasso.with(ProfilDrawerActivity.this).load(img).resize(400 ,400).centerCrop().placeholder(R.drawable.ic_menu_gallery).into(ivlocal);
        //populate info on Drawer
        tvVille.setText(userName);
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
