package com.encoders.eva.coordinatorlayoutcustom;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    protected ActionBarDrawerToggle actionBarDrawerToggle;
    protected NavigationView navigationView;
    private View headerLayout;

    protected DrawerLayout mDrawerLayout;
    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        //get all the views' objects
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);                  //for action bar
        navigationView = (NavigationView) findViewById(R.id.navigation);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //inflate header layout and add it to nav view dynamically
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        navigationView.addHeaderView(inflater.inflate(R.layout.header_layout, null));
        //set action bar with the toolbar
        setSupportActionBar(toolbar);
        // use drawer, toolbar for creating a ActionBarDrawerToggle
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        //use this view for all the view operations of header_layout
        headerLayout = navigationView.getHeaderView(0);
    }
}