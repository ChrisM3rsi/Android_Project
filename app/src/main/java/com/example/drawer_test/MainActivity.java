package com.example.drawer_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment=getSupportFragmentManager().findFragmentById(R.id.fragment2);
        fragment.getView().setBackgroundColor(Color.parseColor("#3A9EC5"));

        //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
       // fragmentTransaction.add(R.id.fragment_welcome,)
        //fragmentTransaction.commit();
        //fragmentTransaction.replace(R.id.fragment_container, homeFragment);
    }
}