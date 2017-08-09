package com.kolektesan.julio.kolektesan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.kolektesan.julio.kolektesan.R;
import com.kolektesan.julio.kolektesan.model.Centre;

public class ScrollingActivityDetailArticle extends AppCompatActivity {
    Centre centre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_detail_article);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView  tvAdresse = (TextView) findViewById(R.id.tvAdresse);

        centre =  (Centre) getIntent().getSerializableExtra("details");
        tvAdresse.setText(centre.getTrlrphone().toString());
        getSupportActionBar().setTitle(centre.getLieu().toString());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT," https://play.google.com/store/apps/details?id=jfsl.jobetrouve " +centre.getTrlrphone()  );
                startActivity(Intent.createChooser(shareIntent, "JEAN FILS Julio "));
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
