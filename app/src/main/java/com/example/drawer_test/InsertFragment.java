package com.example.drawer_test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class InsertFragment extends Fragment {
    EditText kwdikos,onoma,eidos,fullo;
    Button bt;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;

    public InsertFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Insert.
     */
    // TODO: Rename and change types and number of parameters
    public static InsertFragment newInstance(String param1, String param2) {
        InsertFragment fragment = new InsertFragment();
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
        View view =inflater.inflate(R.layout.fragment_insert,container,false);
        kwdikos=view.findViewById(R.id.kwdikos_ins_athlima);
        onoma= view.findViewById(R.id.onoma_ins_athlima);
        fullo=view.findViewById(R.id.fullo_ins_athlima);
        eidos=view.findViewById(R.id.eidos_ins_athlima);
        bt= (Button) view.findViewById(R.id.insertbt_athlima);
        bt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                boolean flag=false;
                int user_id=-1;
                try {
                    user_id=Integer.parseInt(kwdikos.getText().toString());
                }
                catch (NumberFormatException e){
                    System.out.println("Could not parse " + e);
                }
                String user_onoma=onoma.getText().toString();
                String user_eidos=eidos.getText().toString();
                String user_fullo=fullo.getText().toString();
                List<Sports_Class_Local> sports=MainActivity.sports_db_local.myDao().getSports();
                for (Sports_Class_Local i: sports){
                    int id =i.getId();
                    if(id == user_id){
                        flag=true;
                    }
                }

                if (flag){
                    Toast.makeText(getActivity(),"oops, this id allready exists try another one!",Toast.LENGTH_SHORT).show();
                }

               else if(user_onoma.isEmpty() || user_eidos.isEmpty() || user_fullo.isEmpty() || user_id==-1){
                    Toast.makeText(getActivity(), "Please insert all fields!", Toast.LENGTH_SHORT).show();
                }


                else {
                    Sports_Class_Local sport = new Sports_Class_Local();
                    sport.setId(user_id);
                    sport.setName(user_onoma);
                    sport.setType(user_eidos);
                    sport.setGender(user_fullo);
                    MainActivity.sports_db_local.myDao().addSport(sport);
                    Toast.makeText(getActivity(), "insert successful!", Toast.LENGTH_LONG).show();


                }
                kwdikos.setText("");
                onoma.setText("");
                fullo.setText("");
                eidos.setText("");

            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}