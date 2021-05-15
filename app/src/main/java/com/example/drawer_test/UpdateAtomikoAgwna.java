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
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpdateAtomikoAgwna#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateAtomikoAgwna extends Fragment {
    private static String sport;
     CollectionReference collectionReference;
     DocumentReference documentReference;
    Button btn;
    EditText id,hmeromhnia,poli,xwra;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UpdateAtomikoAgwna(String sport) {
        this.sport=sport;
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdateAtomikoAgwna.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateAtomikoAgwna newInstance(String param1, String param2) {
        UpdateAtomikoAgwna fragment = new UpdateAtomikoAgwna(sport);
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
        View view=inflater.inflate(R.layout.fragment_update_atomiko_agwna,container,false);
        btn=(Button) view.findViewById(R.id.updatebt_atomikou_agwna);
        id=view.findViewById(R.id.kwdikos_update_agwna);
        hmeromhnia=view.findViewById(R.id.hmeromhnia_update_athlitwn);
        xwra=view.findViewById(R.id.xwra_update_agwna);
        poli=view.findViewById(R.id.poli_update_agwna);
        ConstraintLayout layout=(ConstraintLayout) view.findViewById(R.id.update_agwna_layout);
        ConstraintSet constraintSet=new ConstraintSet();


        final double[] arithmos = new double[1];
        btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                List<athlites> athlites=new ArrayList<athlites>();

                documentReference=MainActivity.remote_db.collection("Atomikoi_Agwnes").document(id.getText().toString());
                documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            arithmos[0] =documentSnapshot.getDouble("arithmosAthlitwn");  //object orriented languages be like....
                            Toast.makeText(getActivity(),"This id exists!",Toast.LENGTH_SHORT).show();
                            int temp_id=0;
                            EditText[] txt= new EditText[(int)arithmos[0]];
                            int[] ids=new int[(int)arithmos[0]];
                            for( int i=0; i<txt.length;i++){
                                txt[i] = new EditText(getActivity());
                                txt[i].setHint("Τροποποίηση αθλητή " + (i + 1));

                                temp_id=View.generateViewId();
                                ids[i]=temp_id;
                                txt[i].setId(temp_id);




                                ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                                        ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT
                                );


                                txt[i].setLayoutParams(params);

                                layout.addView(txt[i]);
                                constraintSet.clone(layout);
                                if(i==0)
                                    constraintSet.connect(temp_id, ConstraintSet.TOP,R.id.xwra_update_agwna,ConstraintSet.BOTTOM,0);
                                else
                                    constraintSet.connect(temp_id,ConstraintSet.TOP,ids[i-1],ConstraintSet.BOTTOM,0);
                                constraintSet.connect(temp_id,ConstraintSet.END,R.id.update_agwna_layout,ConstraintSet.END,0);
                                constraintSet.applyTo(layout);

                            }

                            Button btn=new Button(getActivity());
                            btn.setText("Update "+sport);
                            temp_id=View.generateViewId();
                            btn.setId(temp_id);
                            btn.setBackgroundColor(getResources().getColor(R.color.mple));
                            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                                    ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT
                            );
                            btn.setLayoutParams(params);
                            btn.setOnClickListener(new View.OnClickListener(){

                                @Override
                                public void onClick(View v) {

                                    String user_hmeromhnia=hmeromhnia.getText().toString();
                                    String user_poli=poli.getText().toString();
                                    String user_xwra=xwra.getText().toString();


                                    if(user_hmeromhnia.isEmpty() || user_poli.isEmpty() || user_xwra.isEmpty()  || user_xwra.isEmpty()){
                                        Toast.makeText(getActivity(), "Please insert all necessary fields!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        try {
                                            Map<String, Object> athlitis = new HashMap<>();
                                            athlitis.put("athlima",sport);
                                            athlitis.put("hmeromhnia",user_hmeromhnia);
                                            athlitis.put("poli",user_poli);
                                            athlitis.put("xwra",user_xwra);
                                            for( int i=0; i<ids.length;i++){
                                                athlites athltis=new athlites();
                                                EditText tmp=view.findViewById(ids[i]);
                                                athltis.setEpwnumo(tmp.getText().toString());
                                                athlites.add(athltis);

                                            }
                                            athlitis.put("athlites",athlites);
                                            documentReference.update(athlitis).addOnCompleteListener(new OnCompleteListener<Void>() {
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


                                        }
                                        catch (Exception e){
                                            String message=e.getMessage();
                                            Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                                        }
                                    }
                                    hmeromhnia.setText("");
                                    poli.setText("");
                                    xwra.setText("");
                                    id.setText("");
                                }


                            });
                            layout.addView(btn);
                            constraintSet.clone(layout);

                            constraintSet.connect(temp_id,ConstraintSet.TOP,ids[ids.length-1],ConstraintSet.BOTTOM,0);
                            constraintSet.connect(temp_id,ConstraintSet.END,R.id.update_agwna_layout,ConstraintSet.END,0);


                            constraintSet.applyTo(layout);


                        } else {
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