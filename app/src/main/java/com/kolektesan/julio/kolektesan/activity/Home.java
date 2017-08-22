package com.kolektesan.julio.kolektesan.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
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

import com.astuetz.PagerSlidingTabStrip;
import com.kolektesan.julio.kolektesan.AboutKolekte;
import com.kolektesan.julio.kolektesan.R;
import com.kolektesan.julio.kolektesan.fragment.FragmentInfos;
import com.kolektesan.julio.kolektesan.fragment.FragmentListInfo;
import com.kolektesan.julio.kolektesan.fragment.FragmentListPosition;
import com.kolektesan.julio.kolektesan.fragment.FragmentProfil;
import com.kolektesan.julio.kolektesan.fragment.PubFragment;

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
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

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
        // ImageView ivHeaderPhoto = headerLayout.findViewById(R.id.iv);
         /*
             if(savedInstanceState==null){
              */
            /*
            FragmentProfil fragmentr = new FragmentProfil();
            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragmentr).commit();

           }
        */
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
            case R.id.profil:
                Intent profil =  new Intent(this, ProfilDrawerActivity.class);
                startActivity(profil);
                break;
            case R.id.nav_about:
                Intent about =  new Intent(this, AboutKolekte.class);
                startActivity(about);
                break;
            case R.id.demande:
                Intent demande =  new Intent(this, Demande.class);
                startActivity(demande);
                break;
            case R.id.planifier:
                Intent planifier =  new Intent(this, Planifier.class);
                startActivity(planifier);
                break;
            case R.id.logOut:
                System.exit(1);
                break;
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
        private int tabTitles[] = {R.drawable.ic_action_home, R.drawable.ic_action_inf, R.drawable.ic_action_menu,
                R.drawable.ic_action_stat ,R.drawable.ic_action_person};

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
                return new FragmentInfos();
            } else if (position == 4) {
                return new FragmentProfil();
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
