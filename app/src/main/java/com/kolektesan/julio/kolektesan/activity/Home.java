package com.kolektesan.julio.kolektesan.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.kolektesan.julio.kolektesan.ActivityTransition;
import com.kolektesan.julio.kolektesan.R;
import com.kolektesan.julio.kolektesan.fragment.FragmentListDemande;
import com.kolektesan.julio.kolektesan.fragment.FragmentListInfo;
import com.kolektesan.julio.kolektesan.fragment.FragmentListPosition;
import com.kolektesan.julio.kolektesan.fragment.FragmentStat;
import com.kolektesan.julio.kolektesan.fragment.PubFragment;

public class Home extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    // Make sure to be using android.support.v7.app.ActionBarDrawerToggle version.
    // The android.support.v4.app.ActionBarDrawerToggle has been deprecated.
    private ActionBarDrawerToggle drawerToggle;
    ImageView imHeader;
    public TextView tvName;

    SharedPreferences prefs ;
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
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        // getSupportActionBar().setTitle("KOLEKTE");
        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        nvDrawer = (NavigationView) findViewById(R.id.nav_view);
        // Setup drawer view
        setupDrawerContent(nvDrawer);

        drawerToggle = setupDrawerToggle();
        // Tie DrawerLayout events to the ActionBarToggle
        mDrawer.addDrawerListener(drawerToggle);

        // We can now look up items within the header if needed
        imHeader= (ImageView) nvDrawer.getHeaderView(0).findViewById(R.id.ivlocal);
    /*    tvName = (TextView) nvDrawer.getHeaderView(0).findViewById(R.id.TvName);


        String userName = prefs.getString("name", "n/a");
        String email = prefs.getString("email", "n/a");
        String img = prefs.getString("imageUri","default.png");
        Picasso.with(Home.this).load(img).resize(400 ,400).centerCrop().placeholder(R.drawable.ic_action_profil).into(imHeader);
        // populate info on Drawer
        tvName.setText(userName);*/
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }
    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.navigation_drawer_close);
    }


    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            /*
            case R.id.profil:
                Intent profil =  new Intent(this, ProfilDrawerActivity.class);
                startActivity(profil);
                break;
            */
            case R.id.nav_about:
                Intent about =  new Intent(this, AboutKolekte.class);
                startActivity(about);
                break;

            case R.id.codingBy:
                Intent codingBy =  new Intent(this, ActivityTransition.class);
                startActivity(codingBy);
                break;
           /*
            case R.id.demande:
                Intent demande =  new Intent(this, Demande.class);
                startActivity(demande);
                break;
           */
           /*  case R.id.planifier:
                Intent planifier =  new Intent(this, Planifier.class);
                startActivity(planifier);
                break;*/
            /*case R.id.logOut:
                logout();
                break;*/
              /*
                case R.id.nav_second_fragment:
                    fragmentClass = SecondFragment.class;
                    break;
                case R.id.nav_third_fragment:
                    fragmentClass = ThirdFragment.class;
                    break;

                fragmentClass = FirstFragment.class;
              */
            default:
        }
        /*
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        */
        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        // mDrawer.closeDrawers();
    }
    public void logout(){
        prefs.edit().clear().commit();
        System.exit(1);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }


    public class ArticlesPagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {
        final int PAGE_COUNT = 5;
        //private String tabTitles[] = new String[]{"Mes Institutions","Mes Formations" ,"Mes Participants"};
        private int tabTitles[] = {R.drawable.ic_action_home, R.drawable.ic_action_inf, R.drawable.ic_action_medi,
                R.drawable.ic_action_stat ,R.drawable.ic_action_ask};

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
                return new PubFragment();
            }else if (position == 3) {
                return new FragmentStat();
            } else if (position == 4) {
                return new FragmentListDemande();
            } else {
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
        inflater.inflate(R.menu.more, menu);
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
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
