package com.example.drawer_test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.type.DateTime;

import org.joda.time.DateTimeComparator;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Show_Queries#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Show_Queries extends Fragment {
    Spinner spinner;
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

    public Show_Queries() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Queries.
     */
    // TODO: Rename and change types and number of parameters
    public static Show_Queries newInstance(String param1, String param2) {
        Show_Queries fragment = new Show_Queries();
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
       View view =inflater.inflate(R.layout.fragment_queries,container,false);
       spinner=view.findViewById(R.id.spinner);
       adapter=ArrayAdapter.createFromResource(getContext(),R.array.show_queries,R.layout.support_simple_spinner_dropdown_item);
       adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
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

       queryResult=view.findViewById(R.id.query_result);
       btn=view.findViewById(R.id.run_queries);
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               final String[] result = {""};
               switch (test){
                   case 0:
                       List<Sports_Class_Local> sports=MainActivity.sports_db_local.myDao().getSports();
                       for(Sports_Class_Local i: sports){
                           int code=i.getId();
                           String onoma=i.getName();
                           String eidos=i.getType();
                           String gender=i.getGender();
                           result[0] = result[0] + "id: "+code + " Name: " + onoma +" Type: " +eidos + " Gender: "+gender +"\n\n";
                       }
                       queryResult.setText(result[0]);
                       break;
                   case 1:
                       List<Athlete_Class_Local> athletes=MainActivity.sports_db_local.myDao().getAthletes();
                       for(Athlete_Class_Local i: athletes){
                           int code=i.getId();
                           String onoma=i.getOnoma();
                           String epwnumo=i.getEpwnumo();
                           String  edra= i.getEdra();
                           String xwra= i.getXwra();
                           int athlima=i.getSportId();
                           String gennisi=i.getEtosGennisis();

                           result[0] = result[0] + "id: "+code + " Name: " + onoma +" Surname: " +epwnumo + " Home: "+edra + " Origin: "+xwra + " Born: "+gennisi+ " Sport_Id: "+athlima +"\n\n";
                       }
                       queryResult.setText(result[0]);
                       break;


                   case 2:
                       List<Omada_Class_Local> omades=MainActivity.sports_db_local.myDao().getOmades();
                       for(Omada_Class_Local i: omades){
                           int code=i.getId();
                           String onoma=i.getOnoma();
                           String gipedo=i.getGipedo();
                           String  etos= i.getEtosIdrisis();
                           String xwra= i.getXwra();
                           int athlima=i.getSportId();
                           String poli=i.getPolh();

                           result[0] = result[0] + "id: "+code + " Name: " + onoma +" Stadium: " +gipedo + " Created: "+etos + " Origin: "+xwra + " City: "+poli+ " Sport_Id: "+athlima +"\n\n";
                       }
                       queryResult.setText(result[0]);
                       break;


                   case 3:
                       List<Athlete_Class_Local> athletesSport=MainActivity.sports_db_local.myDao().getAthletesSport();
                       for(Athlete_Class_Local i: athletesSport){

                           String sport=i.getSport().getName();
                           String epwnumo=i.getEpwnumo();
                           String onoma=i.getOnoma();
                           result[0] = result[0] +"Onoma: "+onoma+" Epwnumo: "+epwnumo+" Athlima: "+sport +"\n\n";

                       }
                       queryResult.setText(result[0]);
                       break;

                   case 4:
                       CollectionReference collectionReference=MainActivity.remote_db.collection("Atomikoi_Agwnes");
                       collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                           @Override
                           public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                               try {
                                   int minYear = 3000;
                                   int minMonth = 13;
                                   int minDays = 32;
                                   String poli = null;
                                   String xwra = null;
                                   String athlima = null;
                                   String minHmeromhnia = "test";
                                   for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                                       Agwnes_Remote agwnes = documentSnapshot.toObject(Agwnes_Remote.class);
                                       String hmeromhnia = agwnes.getHmeromhnia();

                                       String[] test = hmeromhnia.split("/");
                                       if (Integer.parseInt(test[2]) < minYear) {
                                            minYear = Integer.parseInt(test[2]);
                                           minHmeromhnia = hmeromhnia;
                                           poli = agwnes.getPoli();
                                           xwra = agwnes.getXwra();
                                           athlima = agwnes.getAthlima();
                                       } else {

                                           if (Integer.parseInt(test[1]) < minMonth && Integer.parseInt(test[2]) < minYear) {
                                               minMonth = Integer.parseInt(test[1]);
                                               minHmeromhnia = hmeromhnia;
                                               poli = agwnes.getPoli();
                                               xwra = agwnes.getXwra();
                                               athlima = agwnes.getAthlima();
                                           } else {
                                               if (Integer.parseInt(test[0]) < minDays && Integer.parseInt(test[2]) < minYear && Integer.parseInt(test[1]) < minMonth) {
                                                   minDays = Integer.parseInt(test[0]);
                                                   minHmeromhnia = hmeromhnia;
                                                   poli = agwnes.getPoli();
                                                   xwra = agwnes.getXwra();
                                                   athlima = agwnes.getAthlima();
                                               }
                                           }
                                       }

                                   }
                                   result[0] = result[0] + "Ημερομηνία: " + minHmeromhnia + " Πόλη: " + poli + " " +
                                           "Χώρα : " + xwra + " Άθλημα: " + athlima;
                                   queryResult.setText(result[0]);
                               }
                               catch(Exception e){
                                   String message=e.getMessage();
                                   Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                               }
                           }
                       });
                       break;
                   case 5:
                       collectionReference=MainActivity.remote_db.collection("Omadikoi_Agwnes");
                       collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                           @Override
                           public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                               try {
                                   int minYear = 3000;
                                   int minMonth = 13;
                                   int minDays = 32;
                                   String poli = null;
                                   String xwra = null;
                                   String athlima = null;
                                   String minHmeromhnia = "test";
                                   for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                                       Agwnes_Remote agwnes = documentSnapshot.toObject(Agwnes_Remote.class);
                                       String hmeromhnia = agwnes.getHmeromhnia();

                                       String[] test = hmeromhnia.split("/");
                                       if (Integer.parseInt(test[2]) < minYear) {
                                           minYear = Integer.parseInt(test[2]);
                                           minHmeromhnia = hmeromhnia;
                                           poli = agwnes.getPoli();
                                           xwra = agwnes.getXwra();
                                           athlima = agwnes.getAthlima();
                                       } else {

                                           if (Integer.parseInt(test[1]) < minMonth && Integer.parseInt(test[2]) < minYear) {
                                               minMonth = Integer.parseInt(test[1]);
                                               minHmeromhnia = hmeromhnia;
                                               poli = agwnes.getPoli();
                                               xwra = agwnes.getXwra();
                                               athlima = agwnes.getAthlima();
                                           } else {
                                               if (Integer.parseInt(test[0]) < minDays && Integer.parseInt(test[2]) < minYear && Integer.parseInt(test[1]) < minMonth) {
                                                   minDays = Integer.parseInt(test[0]);
                                                   minHmeromhnia = hmeromhnia;
                                                   poli = agwnes.getPoli();
                                                   xwra = agwnes.getXwra();
                                                   athlima = agwnes.getAthlima();
                                               }
                                           }
                                       }

                                   }
                                   result[0] = result[0] + "Ημερομηνία: " + minHmeromhnia + " Πόλη: " + poli + " " +
                                           "Χώρα : " + xwra + " Άθλημα: " + athlima;
                                   queryResult.setText(result[0]);
                               }
                               catch(Exception e){
                                   String message=e.getMessage();
                                   Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                               }
                           }
                       });
               }
           }
       });
        return view;
    }
}