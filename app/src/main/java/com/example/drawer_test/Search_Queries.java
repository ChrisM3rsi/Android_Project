package com.example.drawer_test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Search_Queries#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Search_Queries extends Fragment {
    Spinner spinner;
    EditText id;
    ArrayAdapter<CharSequence> adapter;
    TextView queryResult;
    Button btn;
    int test;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Search_Queries() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Search_Queries.
     */
    // TODO: Rename and change types and number of parameters
    public static Search_Queries newInstance(String param1, String param2) {
        Search_Queries fragment = new Search_Queries();
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
        View view =inflater.inflate(R.layout.fragment_search__queries,container,false);
        spinner=view.findViewById(R.id.spinner);
        adapter=ArrayAdapter.createFromResource(getContext(),R.array.search_queries,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        id=view.findViewById(R.id.search_id);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                test=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        queryResult=view.findViewById(R.id.query_result_search);
        btn=view.findViewById(R.id.run_queries_search);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result="";
                switch (test){
                    case 0:
                        try {
                            Sports_Class_Local sport = MainActivity.sports_db_local.myDao().getSport(Integer.parseInt(id.getText().toString()));
                            int code = sport.getId();
                            String onoma = sport.getName();
                            String eidos = sport.getType();
                            String gender = sport.getGender();
                            result = result + "id:" + code + " Name:" + onoma + " Type:" + eidos + " Gender:" + gender;

                            queryResult.setText(result);
                            break;
                        }
                        catch(Exception e){
                           String  message=e.getMessage();
                            Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                        }

                }
            }
        });
        return view;
    }
}