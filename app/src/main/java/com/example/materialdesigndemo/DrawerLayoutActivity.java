package com.example.materialdesigndemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 2017/3/1.
 */
public class DrawerLayoutActivity extends AppCompatActivity{
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private List<Person> mPersons=new ArrayList<>();
    private MyAdapter mMyAdapter;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawerlayout);
        //initData();

        mToolbar= (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(mToolbar);
        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawerlayout);
        NavigationView navigationView= (NavigationView) findViewById(R.id.nav_view);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(android.R.drawable.ic_menu_more);
        }
        FloatingActionButton fab= (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"data",Snackbar.LENGTH_SHORT)
                        .setAction("undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(DrawerLayoutActivity.this,"data res",Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
        //
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_call:
                        Intent intent=new Intent(getApplicationContext(),TabLayoutActivity.class);
                        startActivity(intent);
                        break;
                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mMyAdapter=new MyAdapter(mPersons);
        mRecyclerView.setAdapter(mMyAdapter);
        initFresh();
    }

    private void initFresh() {
        mSwipeRefreshLayout= (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
    }

    private void refresh() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mPersons.clear();
                        initData();
                        mMyAdapter.notifyDataSetChanged();
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initData() {
        mPersons.add(new Person("蕾姆",R.drawable.lm1));
        mPersons.add(new Person("蕾姆",R.drawable.lm2));
        mPersons.add(new Person("蕾姆",R.drawable.lm3));
        mPersons.add(new Person("蕾姆",R.drawable.lm4));
        mPersons.add(new Person("蕾姆",R.drawable.lm5));
        mPersons.add(new Person("蕾姆",R.drawable.lm6));
        mPersons.add(new Person("蕾姆",R.drawable.lm7));
        mPersons.add(new Person("蕾姆",R.drawable.lm8));
        mPersons.add(new Person("蕾姆",R.drawable.lm9));
        mPersons.add(new Person("蕾姆",R.drawable.lm10));
        mPersons.add(new Person("蕾姆",R.drawable.lm11));
        mPersons.add(new Person("蕾姆",R.drawable.lm12));
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(findViewById(R.id.nav_view)))
            mDrawerLayout.closeDrawers();
        else
            super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
                break;
        }
        return true;
    }
}
