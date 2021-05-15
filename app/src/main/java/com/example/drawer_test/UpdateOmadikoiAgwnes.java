package com.example.drawer_test;

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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpdateOmadikoiAgwnes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateOmadikoiAgwnes extends Fragment {
    private static String sport;
    CollectionReference collectionReference;
    DocumentReference documentReference;
    Button btn;
    EditText hmeromhnia,xwra,poli,omada1,omada2,scor1,scor2,kwdikos;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UpdateOmadikoiAgwnes(String sport) {
        // Required empty public constructor
        this.sport=sport;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdateOmadikoiAgwnes.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateOmadikoiAgwnes newInstance(String param1, String param2) {
        UpdateOmadikoiAgwnes fragment = new UpdateOmadikoiAgwnes(sport);
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
        View view=inflater.inflate(R.layout.fragment_update_omadikoi_agwnes,container,false);
        btn=(Button) view.findViewById(R.id.updatebt_omadikwn_agwnwn);
        kwdikos=view.findViewById(R.id.kwdikos_update_omada);
        hmeromhnia=view.findViewById(R.id.hmerominia_update_omadas);
        xwra=view.findViewById(R.id.xwra_update_omadas);
        poli=view.findViewById(R.id.poli_update_omadas);
        omada1=view.findViewById(R.id.Prwth_omada_update);
        omada2=view.findViewById(R.id.Deuterh_omada_update);
        scor1=view.findViewById(R.id.scor_update_omada1);
        scor2=view.findViewById(R.id.scor_update_omada2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                documentReference=MainActivity.remote_db.collection("Omadikoi_Agwnes").document(kwdikos.getText().toString());
                documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            int user_Scor1 = -1;
                            int user_Scor2 = -1;
                            int user_kwdikos = -1;
                            try {
                                user_kwdikos = Integer.parseInt(kwdikos.getText().toString());
                                user_Scor1 = Integer.parseInt(scor1.getText().toString());
                                user_Scor2 = Integer.parseInt(scor2.getText().toString());
                            } catch (NumberFormatException e) {
                                String mess = e.getMessage();
                                Toast.makeText(getActivity(), mess, Toast.LENGTH_SHORT).show();
                            }
                            String user_hmeromhnia = hmeromhnia.getText().toString();
                            String user_poli = poli.getText().toString();
                            String user_xwra = xwra.getText().toString();

                            String user_omada1 = omada1.getText().toString();
                            String user_omada2 = omada2.getText().toString();

                            if (user_hmeromhnia.isEmpty() || user_poli.isEmpty() || user_xwra.isEmpty() || user_kwdikos == -1 || user_xwra.isEmpty() || user_omada1.isEmpty() || user_omada2.isEmpty() || user_Scor1 == -1 || user_Scor2 == -1) {
                                Toast.makeText(getActivity(), "Please insert all necessary fields!", Toast.LENGTH_SHORT).show();
                            } else {
                                try {
                                    Map<String, Object> agwnes = new HashMap<>();
                                    agwnes.put("athlima", sport);
                                    agwnes.put("hmeromhnia", user_hmeromhnia);
                                    agwnes.put("poli", user_poli);
                                    agwnes.put("xwra", user_xwra);
                                    agwnes.put("omada1", user_omada1);
                                    agwnes.put("omada2", user_omada2);
                                    agwnes.put("scor1", user_Scor1);
                                    agwnes.put("scor2", user_Scor2);

                                    documentReference.update(agwnes).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(getActivity(), "updated successfully!", Toast.LENGTH_SHORT).show();
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(getActivity(), "ERROR update operation was not successful", Toast.LENGTH_LONG).show();
                                        }
                                    });
                                } catch (Exception e) {
                                    String message = e.getMessage();
                                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
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
                        }else {
                            Toast.makeText(getActivity(), "This document does not exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity(), "this document does not exist!", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
        return view;

    }
}