package com.example.drawer_test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpdateAgwnaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateAgwnaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UpdateAgwnaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdateAgwnaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateAgwnaFragment newInstance(String param1, String param2) {
        UpdateAgwnaFragment fragment = new UpdateAgwnaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_update_agwna,container,false);
        LinearLayout linearLayout= (LinearLayout) view.findViewById(R.id.update_agwna);
        List<Sports_Class_Local> sports=MainActivity.sports_db_local.myDao().getSports();
        int size=sports.size() ;
        Button[] btn = new Button[size];
        int j=0;
        for (Sports_Class_Local i: sports){
            String name =i.getName();
            btn[j] =new Button(getActivity());

            btn[j].setText("update "+name);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(10, 200, 10, 10);
            btn[j].setLayoutParams(params);
            btn[j].setBackgroundColor(getResources().getColor(R.color.mple));
            btn[j].setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    if(i.getType().equalsIgnoreCase("ατομικό")){
                        UpdateAtomikoAgwna updateAtomikoAgwna=new UpdateAtomikoAgwna(i.getName());
                        getFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left_to_right,R.anim.exit_left_to_right).replace(R.id.fragment_container,updateAtomikoAgwna).addToBackStack(null).commit();
                    }
                    else {
                        UpdateOmadikoiAgwnes updateOmadikoAgwna = new UpdateOmadikoiAgwnes(i.getName());
                        getFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left_to_right, R.anim.exit_left_to_right).replace(R.id.fragment_container, updateOmadikoAgwna).addToBackStack(null).commit();

                    }

                }


            });
            //btn[j].setMinimumHeight(150);
            //btn[j].setMinimumWidth(150);
            linearLayout.addView(btn[j]);
            j++;
        }
        return view;
    }
}