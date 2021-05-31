package com.example.drawer_test;

import android.os.Bundle;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

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
                final String[] result = {""};
                switch (test){
                    case 0:
                        boolean flag=true;
                        List<Sports_Class_Local> sports=MainActivity.sports_db_local.myDao().getSports();
                        for (Sports_Class_Local i: sports){
                            int code =i.getId();
                            if(code == Integer.parseInt(id.getText().toString())){
                                flag=false;
                            }
                        }

                        if (flag){
                            Toast.makeText(getActivity(),"This id does not exist!",Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else {
                            try {
                                Sports_Class_Local sport = MainActivity.sports_db_local.myDao().getSport(Integer.parseInt(id.getText().toString()));
                                int code = sport.getId();
                                String onoma = sport.getName();
                                String eidos = sport.getType();
                                String gender = sport.getGender();
                                result[0] = result[0] + "id: " + code + " Name: " + onoma + " Type: " + eidos + " Gender: " + gender;

                                queryResult.setText(result[0]);
                                break;
                            } catch (Exception e) {
                                String message = e.getMessage();
                                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                            }
                        }
                    case 1:
                        flag=true;
                        List<Athlete_Class_Local> athletes=MainActivity.sports_db_local.myDao().getAthletes();
                        for (Athlete_Class_Local i: athletes){
                            int code =i.getId();
                            if(code == Integer.parseInt(id.getText().toString())){
                                flag=false;
                            }
                        }
                        if(flag) {
                            Toast.makeText(getActivity(), "oops, This id does not exist, try another one!", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else {
                            try {

                                Athlete_Class_Local athlete = MainActivity.sports_db_local.myDao().getAthlete(Integer.parseInt(id.getText().toString()));
                                int code = athlete.getId();
                                String onoma = athlete.getOnoma();
                                String edra = athlete.getEdra();
                                String epwnumo = athlete.getEpwnumo();
                                int athlima = athlete.getSportId();
                                String gennisi = athlete.getEtosGennisis();
                                String xwra = athlete.getXwra();
                                result[0] = result[0] = result[0] + "id: " + code + " Name: " + onoma + " Surname: " + epwnumo + " Home: " + edra + " Origin: " + xwra + " Born: " + gennisi + " Sport_Id: " + athlima + "\n\n";

                                queryResult.setText(result[0]);
                                break;
                            } catch (Exception e) {
                                String message = e.getMessage();
                                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                            }
                        }

                    case 2:
                        flag=true;
                        List<Omada_Class_Local> omades = MainActivity.sports_db_local.myDao().getOmades();
                        for (Omada_Class_Local i : omades) {
                            int code = i.getId();
                            if (code == Integer.parseInt(id.getText().toString())) {
                                flag = false;
                            }
                        }

                        if (flag) {
                            Toast.makeText(getActivity(), "oops, This id does not exist, try another one!", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else {
                            try {
                                Omada_Class_Local omada = MainActivity.sports_db_local.myDao().getOmada(Integer.parseInt(id.getText().toString()));
                                int code = omada.getId();
                                String onoma = omada.getOnoma();
                                String gipedo = omada.getGipedo();
                                String etos = omada.getEtosIdrisis();
                                String xwra = omada.getXwra();
                                int athlima = omada.getSportId();
                                String poli = omada.getPolh();

                                result[0] = result[0] + "id: " + code + " Name: " + onoma + " Stadium: " + gipedo + " Created: " + etos + " Origin: " + xwra + " City: " + poli + " Sport_Id: " + athlima + "\n\n";

                                queryResult.setText(result[0]);
                                break;
                            } catch (Exception e) {
                                String message = e.getMessage();
                                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                            }
                        }
                    case 3:
                        DocumentReference documentReference=MainActivity.remote_db.collection("Atomikoi_Agwnes").document(id.getText().toString());
                       documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                           @Override
                           public void onSuccess(DocumentSnapshot documentSnapshot) {
                               if(documentSnapshot.exists()){
                                   try {
                                       Agwnes_Remote agwnes = documentSnapshot.toObject(Agwnes_Remote.class);
                                       String hmeromhnia = agwnes.getHmeromhnia();
                                       String athlima = agwnes.getAthlima();
                                       String poli = agwnes.getPoli();
                                       String xwra = agwnes.getXwra();

                                       result[0] = result[0] + "id: " + id.getText().toString() + " Name: " + athlima + " Date: " + hmeromhnia + " Sport: " + athlima + " Country: " + xwra + " City: " + poli + "\n\n";
                                       queryResult.setText(result[0]);
                                   }
                                   catch (Exception e){
                                       String message=e.getMessage();
                                       Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
                                   }
                               }
                               else {
                                   Toast.makeText(getActivity(),"this document does not exist!",Toast.LENGTH_SHORT).show();
                               }

                           }
                       }).addOnFailureListener(new OnFailureListener() {
                           @Override
                           public void onFailure(@NonNull Exception e) {
                               Toast.makeText(getActivity(),"An error has occured.",Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;
                    case 4:
                    documentReference=MainActivity.remote_db.collection("Omadikoi_Agwnes").document(id.getText().toString());
                    documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if(documentSnapshot.exists()){
                                try {
                                    Omadikoi_Agwnes agwnes = documentSnapshot.toObject(Omadikoi_Agwnes.class);
                                    String hmeromhnia = agwnes.getHmeromhnia();
                                    String athlima = agwnes.getAthlima();
                                    String poli = agwnes.getPoli();
                                    String xwra = agwnes.getXwra();
                                    int score1=agwnes.getScor1();
                                    int score2=agwnes.getScor2();
                                    String omada1=agwnes.getOmada1();
                                    String omada2=agwnes.getOmada2();

                                    result[0] = result[0] + "id: " + id.getText().toString() + " Sport: " + athlima + " Date: " + hmeromhnia +  " Country: " + xwra +
                                            " City: " + poli + " Team 1: " + omada1 + " Score of Team 1: "+score1 + " Team 2:"+omada2+ "Score of Team 2: "+score2+"\n\n";
                                    queryResult.setText(result[0]);
                                }
                                catch (Exception e){
                                    String message=e.getMessage();
                                    Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(getActivity(),"this document does not exist!",Toast.LENGTH_SHORT).show();
                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity(),"An error has occured.",Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        });
        return view;
    }
}