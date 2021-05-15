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
 * Use the {@link DeleteOmadaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeleteOmadaFragment extends Fragment {
    EditText kwdikos;
    Button bt;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DeleteOmadaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DeleteOmadaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DeleteOmadaFragment newInstance(String param1, String param2) {
        DeleteOmadaFragment fragment = new DeleteOmadaFragment();
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
        View view =inflater.inflate(R.layout.fragment_delete_omada,container,false);
        kwdikos=view.findViewById(R.id.kwdikos_del_Omadas);
        bt= (Button) view.findViewById(R.id.deletebt_omadas);

        bt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                boolean flag=true;
                int user_id=-1;
                try {
                    user_id=Integer.parseInt(kwdikos.getText().toString());
                }
                catch (NumberFormatException e){
                    System.out.println("Could not parse " + e);
                }
                List<Omada_Class_Local> omades=MainActivity.sports_db_local.myDao().getOmades();
                for (Omada_Class_Local i: omades){
                    int id =i.getId();
                    if(id == user_id){
                        flag=false;
                    }
                }

                if (flag){
                    Toast.makeText(getActivity(),"This id does not exist!",Toast.LENGTH_SHORT).show();
                }

                else if(user_id==-1){
                    Toast.makeText(getActivity(), "Please insert the id!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Omada_Class_Local omada = new Omada_Class_Local();
                    omada.setId(user_id);
                    MainActivity.sports_db_local.myDao().deleteOmada(omada);
                    Toast.makeText(getActivity(), "delete successful!", Toast.LENGTH_LONG).show();


                }
                kwdikos.setText("");


            }
        });


        return view;
    }
}