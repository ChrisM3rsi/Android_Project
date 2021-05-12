package com.example.drawer_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

                    case R.id.insert_athlimatos:
                        item.setChecked(true);
                        InsertFragment insertFragment= new InsertFragment();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left_to_right, R.anim.exit_left_to_right).replace(R.id.fragment_container,insertFragment).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.insert_athliti:
                        item.setChecked(true);
                        InsertAthleteFragment insertAthleteFragment= new InsertAthleteFragment();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left_to_right, R.anim.exit_left_to_right).replace(R.id.fragment_container,insertAthleteFragment).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.insert_omadas:
                        item.setChecked(true);
                        InsertOmadaFragment insertOmadaFragment = new InsertOmadaFragment();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left_to_right, R.anim.exit_left_to_right).replace(R.id.fragment_container,insertOmadaFragment).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.update_athlimatos:
                        item.setChecked(true);
                        UpdateFragment updateFragment= new UpdateFragment();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left_to_right, R.anim.exit_left_to_right).replace(R.id.fragment_container,updateFragment).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.emfanisi:
                        item.setChecked(true);
                        Show_Queries show_queries=new Show_Queries();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left_to_right, R.anim.exit_left_to_right).replace(R.id.fragment_container,show_queries).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.anazitisi:
                        item.setChecked(true);
                        Search_Queries search_queries=new Search_Queries();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left_to_right, R.anim.exit_left_to_right).replace(R.id.fragment_container,search_queries).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.update_athliti:
                        item.setChecked(true);
                        UpdateAthleteFragment updateAthleteFragment=new UpdateAthleteFragment();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left_to_right, R.anim.exit_left_to_right).replace(R.id.fragment_container,updateAthleteFragment).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.update_omadas:
                        item.setChecked(true);
                        UpdateOmadaFragment updateOmadaFragment =new UpdateOmadaFragment();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left_to_right, R.anim.exit_left_to_right).replace(R.id.fragment_container,updateOmadaFragment).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.delete_athlimatos:
                        item.setChecked(true);
                        DeleteFragment deleteFragment=new DeleteFragment();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left_to_right, R.anim.exit_left_to_right).replace(R.id.fragment_container,deleteFragment).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.delete_athliti:
                        item.setChecked(true);
                        DeleteAthleteFragment deleteAthleteFragment=new DeleteAthleteFragment();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left_to_right, R.anim.exit_left_to_right).replace(R.id.fragment_container,deleteAthleteFragment).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.delete_omada:
                        item.setChecked(true);
                        DeleteOmadaFragment deleteOmadaFragment =new DeleteOmadaFragment();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left_to_right, R.anim.exit_left_to_right).replace(R.id.fragment_container,deleteOmadaFragment).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.home:
                        item.setChecked(true);
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left_to_right, R.anim.exit_left_to_right).replace(R.id.fragment_container,welcome).addToBackStack(null).commit();
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



}