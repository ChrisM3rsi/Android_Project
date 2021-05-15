package com.example.drawer_test;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InsertOmadikoAgwna#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsertOmadikoAgwna extends Fragment {
    EditText omada1, omada2,scor1,scor2,hmeromhnia,poli,xwra,kwdikos;
    Button btn;
    static String sport;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InsertOmadikoAgwna(String i) {
        sport=i;
    }
        // Required empty public constructor


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InsertOmadikoAgwna.
     */
    // TODO: Rename and change types and number of parameters
    public static InsertOmadikoAgwna newInstance(String param1, String param2) {
        InsertOmadikoAgwna fragment = new InsertOmadikoAgwna(sport);
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_omadiko_agwna, container, false);
        ConstraintLayout layout = (ConstraintLayout) view.findViewById(R.id.emfanisi_fields_omadiko);
        ConstraintSet constraintSet=new ConstraintSet();
        omada1=view.findViewById(R.id.Prwth_omada_instert);
        omada2=view.findViewById(R.id.Deuterh_omada_ins);
        kwdikos=view.findViewById(R.id.kwdikos_insert_omada);
        scor1=view.findViewById(R.id.scor_insert_omada1);
        scor2=view.findViewById(R.id.scor_insert_omada2);
        hmeromhnia=view.findViewById(R.id.hmerominia_insert_omadas);
        xwra=view.findViewById(R.id.xwra_insert_omadas);
        poli=view.findViewById(R.id.poli_insert_omadas);
        btn = (Button) view.findViewById(R.id.insertbt_omadwn);
        btn.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                int user_kwdikos = -1;
                int user_Scor1= -1;
                int user_Scor2= -1;
                try {
                    user_kwdikos = Integer.parseInt(kwdikos.getText().toString());
                    user_Scor1=Integer.parseInt(scor1.getText().toString());
                    user_Scor2=Integer.parseInt(scor2.getText().toString());
                } catch (NumberFormatException e) {
                    System.out.println("Could not parse " + e);
                }
                String user_hmeromhnia = hmeromhnia.getText().toString();
                String user_poli = poli.getText().toString();
                String user_xwra = xwra.getText().toString();
                String user_omada1=omada1.getText().toString();
                String user_omada2=omada2.getText().toString();

                if (user_hmeromhnia.isEmpty() || user_poli.isEmpty() || user_xwra.isEmpty() || user_kwdikos == -1 || user_xwra.isEmpty() || user_omada1.isEmpty()||user_omada2.isEmpty()||user_Scor1==-1||user_Scor2==-1) {
                    Toast.makeText(getActivity(), "Please insert all necessary fields!", Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        Omadikoi_Agwnes omadikoi_agwnes = new Omadikoi_Agwnes();
                        omadikoi_agwnes.setAthlima(sport);
                        omadikoi_agwnes.setHmeromhnia(user_hmeromhnia);
                        omadikoi_agwnes.setXwra(user_xwra);
                        omadikoi_agwnes.setPoli(user_poli);
                        omadikoi_agwnes.setOmada1(user_omada1);
                        omadikoi_agwnes.setOmada2(user_omada2);
                        omadikoi_agwnes.setScor1(user_Scor1);
                        omadikoi_agwnes.setScor2(user_Scor2);
                        MainActivity.remote_db.collection("Omadikoi_Agwnes").document("" + user_kwdikos).set(omadikoi_agwnes).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(getActivity(), "added successfully!", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getActivity(), "ERROR insert operation was not successful", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                    catch (Exception e){
                        String message=e.getMessage();
                        Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                    }
                    hmeromhnia.setText("");
                    poli.setText("");
                    xwra.setText("");
                    kwdikos.setText("");
                    omada1.setText("");
                    omada2.setText("");
                    scor1.setText("");
                    scor2.setText("");
                }

            }
        });
        return view;
    }
}
