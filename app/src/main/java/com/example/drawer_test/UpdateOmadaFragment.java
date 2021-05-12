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
 * Use the {@link UpdateOmadaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateOmadaFragment extends Fragment {
    EditText kwdikos_omadas,onoma_gipedou,polh,onoma_omadas,xwra,kwdikos_athlimatos,etos_idrisis;
    Button bt;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UpdateOmadaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdateOmadaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateOmadaFragment newInstance(String param1, String param2) {
        UpdateOmadaFragment fragment = new UpdateOmadaFragment();
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
        View view =inflater.inflate(R.layout.fragment_insert_omada,container,false);
        kwdikos_omadas=view.findViewById(R.id.kwdikos_ins_omadas);
        onoma_gipedou= view.findViewById(R.id.onomaGipedou_ins_omadas);
        polh=view.findViewById(R.id.poli_ins_omadas);
        onoma_omadas=view.findViewById(R.id.onomaOmadas_ins_omadas);
        xwra= view.findViewById(R.id.xwra_ins_athliti);
        kwdikos_athlimatos=view.findViewById(R.id.kwdikosAthlimatos_ins_omadas);
        etos_idrisis=view.findViewById(R.id.etosIdrisis_ins_omadas);
        bt= (Button) view.findViewById(R.id.insertbt_omadas);
        bt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                boolean flag = true;
                int user_kwdikos = -1;
                int user_kwdikos_omadas = -1;
                try {
                    user_kwdikos = Integer.parseInt(kwdikos_omadas.getText().toString());
                } catch (NumberFormatException e) {
                    System.out.println("Could not parse " + e);
                }
                String user_onomaGipedou = onoma_gipedou.getText().toString();
                String user_polh = polh.getText().toString();
                String user_onomaOmadas = onoma_omadas.getText().toString();
                String user_xwra = xwra.getText().toString();
                try {
                    user_kwdikos_omadas = Integer.parseInt(kwdikos_athlimatos.getText().toString());
                } catch (NumberFormatException e) {
                    System.out.println("Could not parse " + e);
                }
                String user_etosIdrisis = etos_idrisis.getText().toString();

                List<Athlete_Class_Local> athletes = MainActivity.sports_db_local.myDao().getAthletes();
                for (Athlete_Class_Local i : athletes) {
                    int id = i.getId();
                    if (id == user_kwdikos) {
                        flag = false;
                    }
                }

                if (flag) {
                    Toast.makeText(getActivity(), "oops, This id does not exist, try another one!", Toast.LENGTH_SHORT).show();
                } else if (user_onomaGipedou.isEmpty() || user_polh.isEmpty() || user_onomaOmadas.isEmpty() || user_kwdikos == -1 || user_xwra.isEmpty() || user_kwdikos_omadas == -1 || user_etosIdrisis.isEmpty()) {
                    Toast.makeText(getActivity(), "Please insert all fields!", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        Omada_Class_Local omada = new Omada_Class_Local();
                        omada.setId(user_kwdikos);
                        omada.setOnomaOmadas(user_onomaOmadas);
                        omada.setPolh(user_polh);
                        omada.setOnomaGipedou(user_onomaGipedou);
                        omada.setEtosIdrisis(user_etosIdrisis);
                        omada.setSportId(user_kwdikos_omadas);
                        omada.setXwra(user_xwra);

                        MainActivity.sports_db_local.myDao().updateOmada(omada);
                        Toast.makeText(getActivity(), "insert successful!", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();

                    }

                }
                kwdikos_omadas.setText("");
                onoma_gipedou.setText("");
                polh.setText("");
                onoma_omadas.setText("");
                xwra.setText("");
                kwdikos_athlimatos.setText("");
                etos_idrisis.setText("");

            }
        });
        return view;
    }
}
