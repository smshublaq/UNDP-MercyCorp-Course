package com.app.navigationviewexample;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        drawerLayout = findViewById(R.id.drawerLayout);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);

        actionBarDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav);

        View headerView = navigationView.getHeaderView(0);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                Fragment fragment = new MyFragment();
                FragmentUtils.addFragment(this,R.id.container,fragment);
                break;
            case R.id.categories:
                break;
            case R.id.settings:
                break;
        }
        flipMenu(GravityCompat.START);
        return false;
    }

    public void flipMenu(int gravity){
        if(drawerLayout.isDrawerOpen(gravity)){
            drawerLayout.closeDrawer(gravity);
        }
    }

    @Override
    public void onBackPressed() {
        flipMenu(GravityCompat.START);
        super.onBackPressed();
    }
}
