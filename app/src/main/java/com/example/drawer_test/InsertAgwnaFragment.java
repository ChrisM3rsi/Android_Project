package com.example.drawer_test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InsertAgwnaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsertAgwnaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InsertAgwnaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InsertAgwnaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InsertAgwnaFragment newInstance(String param1, String param2) {
        InsertAgwnaFragment fragment = new InsertAgwnaFragment();
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
        View view =inflater.inflate(R.layout.fragment_insert_agwna,container,false);
        LinearLayout linearLayout= (LinearLayout) view.findViewById(R.id.insert_agwna);
        List<Sports_Class_Local> sports=MainActivity.sports_db_local.myDao().getSports();
        int size=sports.size() ;
        Button [] btn = new Button[size];
        int j=0;
        for (Sports_Class_Local i: sports){
            String name =i.getName();
            btn[j] =new Button(getActivity());

            btn[j].setText("add "+name);
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
                        InsertAtomikoAgwna insertAtomikoAgwna=new InsertAtomikoAgwna(i.getName());

                        getFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left_to_right,R.anim.exit_left_to_right).replace(R.id.fragment_container,insertAtomikoAgwna).addToBackStack(null).commit();
                    }
                    else {
                        InsertOmadikoAgwna insertOmadikoAgwna = new InsertOmadikoAgwna(i.getName());
                        getFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left_to_right, R.anim.exit_left_to_right).replace(R.id.fragment_container, insertOmadikoAgwna).addToBackStack(null).commit();

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