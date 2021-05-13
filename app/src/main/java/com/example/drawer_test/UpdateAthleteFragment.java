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
 * Use the {@link UpdateAthleteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateAthleteFragment extends Fragment {
    EditText kwdikos,onoma,epwnumo,edra,xwra,kwdikos_athlimatos,gennisi;
    Button bt;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UpdateAthleteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdateAthleteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateAthleteFragment newInstance(String param1, String param2) {
        UpdateAthleteFragment fragment = new UpdateAthleteFragment();
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
        View view =inflater.inflate(R.layout.fragment_update_athlete,container,false);
        kwdikos=view.findViewById(R.id.kwdikos_upd_athliti);
        onoma= view.findViewById(R.id.onoma_upd_athliti);
        epwnumo=view.findViewById(R.id.eponumo_upd_athliti);
        edra=view.findViewById(R.id.edra_upd_athliti);
        xwra= view.findViewById(R.id.xwra_upd_athliti);
        kwdikos_athlimatos=view.findViewById(R.id.kwdikos_Athlimatos_upd_athliti);
        gennisi=view.findViewById(R.id.gennisi_upd_athliti);
        bt= (Button) view.findViewById(R.id.updatebt_athliti);
        bt.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    boolean flag=true;
                    int user_kwdikos=-1;
                    int user_kwdikos_athlimatos=-1;
                    try {
                        user_kwdikos=Integer.parseInt(kwdikos.getText().toString());
                    }
                    catch (NumberFormatException e){
                        System.out.println("Could not parse " + e);
                    }
                    String user_onoma=onoma.getText().toString();
                    String user_epwnumo=epwnumo.getText().toString();
                    String user_edra=edra.getText().toString();
                    String user_xwra=xwra.getText().toString();
                    try {
                        user_kwdikos_athlimatos = Integer.parseInt(kwdikos_athlimatos.getText().toString());
                    }
                    catch (NumberFormatException e){
                        System.out.println("Could not parse " + e);
                    }
                    String user_gennisi=gennisi.getText().toString();

                    List<Athlete_Class_Local> athletes=MainActivity.sports_db_local.myDao().getAthletes();
                    for (Athlete_Class_Local i: athletes){
                        int id =i.getId();
                        if(id == user_kwdikos){
                            flag=false;
                        }
                    }

                    if (flag){
                        Toast.makeText(getActivity(),"oops, This id does not exist, try another one!",Toast.LENGTH_SHORT).show();
                    }
                    else if(user_onoma.isEmpty() || user_epwnumo.isEmpty() || user_edra.isEmpty() || user_kwdikos==-1 || user_xwra.isEmpty() || user_kwdikos_athlimatos==-1 || user_gennisi.isEmpty()){
                        Toast.makeText(getActivity(), "Please insert all fields!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        try {
                            Athlete_Class_Local athlete = new Athlete_Class_Local();
                            athlete.setId(user_kwdikos);
                            athlete.setEdra(user_edra);
                            athlete.setEpwnumo(user_epwnumo);
                            athlete.setOnoma(user_onoma);
                            athlete.setEtosGennisis(user_gennisi);
                            athlete.setSportId(user_kwdikos_athlimatos);
                            athlete.setXwra(user_xwra);

                            MainActivity.sports_db_local.myDao().updateAthlete(athlete);
                            Toast.makeText(getActivity(), "insert successful!", Toast.LENGTH_LONG).show();
                        }
                        catch (Exception e){
                            String message=e.getMessage();
                            Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();

                        }

                    }
                    kwdikos.setText("");
                    onoma.setText("");
                    epwnumo.setText("");
                    edra.setText("");
                    xwra.setText("");
                    kwdikos_athlimatos.setText("");
                    gennisi.setText("");

                }
        });
        return view;
    }
}