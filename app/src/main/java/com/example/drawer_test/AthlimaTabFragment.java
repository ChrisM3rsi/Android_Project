package com.example.drawer_test;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import  androidx.fragment.app.Fragment;

public class AthlimaTabFragment extends  Fragment{
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root =(ViewGroup) inflater.inflate(R.layout.tab_fragment,container,false);
        return root;
    }
}
