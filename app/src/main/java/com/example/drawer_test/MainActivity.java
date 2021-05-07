package com.example.drawer_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    public static Sports_Db_Local sports_db_local;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sports_db_local= Room.databaseBuilder(getApplicationContext(),Sports_Db_Local.class,"Athlimatadb").allowMainThreadQueries().build();

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigationView);

        //Creating dynamically welcome container so we can replace it afterwards
        Welcome welcome= new Welcome();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,welcome).addToBackStack(null).commit();
        //ConstraintLayout layout =(ConstraintLayout) findViewById(R.id.welcome);
        //layout.setBackgroundColor(Color.parseColor("#3A9EC5"));


        //Fragment fragment=fragmentManager.findFragmentById(R.id.);
        //fragment.getView().setBackgroundColor(Color.parseColor("#3A9EC5"));

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.insert:
                        item.setChecked(true);
                        InsertFragment insertFragment= new InsertFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,insertFragment).addToBackStack(null).commit();
                        displayMessage("insert selected");
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.update:
                        item.setChecked(true);
                        UpdateFragment updateFragment= new UpdateFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,updateFragment).addToBackStack(null).commit();
                        displayMessage("update selected");
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.home:
                        item.setChecked(true);
                        displayMessage("home selected");
                        drawerLayout.closeDrawers();
                        return true;
                }
                return false;
            }
        });

        if(findViewById(R.layout.activity_main)!=null){
            if(savedInstanceState!=null){
                return;
            }
        }


    }

        //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
       // fragmentTransaction.add(R.id.fragment_welcome,)
        //fragmentTransaction.commit();
        //fragmentTransaction.replace(R.id.fragment_container, homeFragment);


    public void  displayMessage(String message){
            Toast.makeText(this,message,Toast.LENGTH_LONG).show();


        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.drawer_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.insert: {
                Toast.makeText(this,"insert selected",Toast.LENGTH_LONG).show();
                return true;
            }
            case R.id.update:{
                UpdateFragment updateFragment= new UpdateFragment();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,updateFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                Fragment fragment= getSupportFragmentManager().findFragmentById(R.id.fragment_container);
                fragment.getView().setBackgroundColor(Color.BLACK);
                Toast.makeText(this,"update selected",Toast.LENGTH_LONG).show();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}