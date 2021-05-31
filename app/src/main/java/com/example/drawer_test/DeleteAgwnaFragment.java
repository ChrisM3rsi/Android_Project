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
 * Use the {@link DeleteAgwnaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeleteAgwnaFragment extends Fragment {
    Button btn1, btn2;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DeleteAgwnaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DeleteAgwnaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DeleteAgwnaFragment newInstance(String param1, String param2) {
        DeleteAgwnaFragment fragment = new DeleteAgwnaFragment();
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
       View view=inflater.inflate(R.layout.fragment_delete_agwna,container,false);
       btn1=view.findViewById(R.id.deletebt_atomikou_agwna);

       btn1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               DeleteAtomikoAgwna deleteAtomikoAgwna=new DeleteAtomikoAgwna();
               getFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left_to_right,R.anim.exit_left_to_right).replace(R.id.fragment_container,deleteAtomikoAgwna).addToBackStack(null).commit();
           }
       });

        btn2=view.findViewById(R.id.deletebt_omadikou_agwna);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteOmadikoAgwna deleteomadikoAgwna=new DeleteOmadikoAgwna();
                getFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left_to_right,R.anim.exit_left_to_right).replace(R.id.fragment_container,deleteomadikoAgwna).addToBackStack(null).commit();
            }
        });

        return view;
    }
}