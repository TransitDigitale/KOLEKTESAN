package com.kolektesan.julio.kolektesan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;
import com.kolektesan.julio.kolektesan.More;
import com.kolektesan.julio.kolektesan.R;
import com.kolektesan.julio.kolektesan.fragment.FragmentListInfo;
import com.kolektesan.julio.kolektesan.fragment.FragmentListPosition;

public class Home extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;

    // Make sure to be using android.support.v7.app.ActionBarDrawerToggle version.
    // The android.support.v4.app.ActionBarDrawerToggle has been deprecated.
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Implement the viewpager
        ViewPager vpPager=(ViewPager)findViewById(R.id.viewpager);
        vpPager.setAdapter(new Home.ArticlesPagerAdapter(getSupportFragmentManager()));
        PagerSlidingTabStrip tabStrip=(PagerSlidingTabStrip)findViewById(R.id.tabs);
        tabStrip.setViewPager(vpPager);
        // Set aba Toolbar to replace the ActionBar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("La Croix Rouge Haïtienne ");
    }
    
    public class ArticlesPagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {
        final int PAGE_COUNT = 5;
        //private String tabTitles[] = new String[]{"Mes Institutions","Mes Formations" ,"Mes Participants"};
        private int tabTitles[] = {R.drawable.ic_action_home, R.drawable.ic_action_inf, R.drawable.ic_action_menu,
                R.drawable.ic_action_shared ,R.drawable.ic_action_person};

        public ArticlesPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new FragmentListPosition();
            } else if (position == 1) {
                return new FragmentListInfo();
            }  else if (position == 2) {
                return new FragmentListPosition();
            }else if (position == 3) {
                return new FragmentListPosition();
            }
            else if (position == 4) {
                return new FragmentListPosition();
            }
            else {
                return null;
            }

        }
        /*
        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return tabTitles[position];
        }
        */
        @Override
        public int getPageIconResId(int position) {
            return tabTitles[position];
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // perform query here

                // workaround to avoid issues with some emulators and keyboard devices firing twice if aba keyboard enter is used
                // see https://code.google.com/p/android/issues/detail?id=24599
                searchView.clearFocus();

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case R.id.options:
                // show the pop up
                    Intent intent = new Intent(Home.this, More.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
