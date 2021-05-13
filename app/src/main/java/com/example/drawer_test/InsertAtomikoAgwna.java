package com.example.drawer_test;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InsertAtomikoAgwna#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsertAtomikoAgwna extends Fragment {
     static String sport;
     EditText arithmos,hmeromhnia,xwra,poli,kwdikos;;
     Button btn;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InsertAtomikoAgwna(String i) {
        sport=i;
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InsertAtomikoAgwna.
     */
    // TODO: Rename and change types and number of parameters
    public static InsertAtomikoAgwna newInstance(String param1, String param2) {
        InsertAtomikoAgwna fragment = new InsertAtomikoAgwna(sport);
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
        View view = inflater.inflate(R.layout.fragment_insert_atomiko_agwna, container, false);
        ConstraintLayout layout = (ConstraintLayout) view.findViewById(R.id.emfanisi_fields);
        ConstraintSet constraintSet=new ConstraintSet();
        hmeromhnia=view.findViewById(R.id.hmeromhnia_insert_agwna);
        xwra=view.findViewById(R.id.xwra_insert_agwna);
        poli=view.findViewById(R.id.poli_insert_agwna);
        kwdikos=view.findViewById(R.id.kwdikos_insert_agwna);

        arithmos = view.findViewById(R.id.arithmos_insert_agwna);
        btn = (Button) view.findViewById(R.id.insertbt_arithmo_agwna);
        EditText[] txt= new EditText[10];

        btn.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                btn.setVisibility(View.GONE);
                int user_arithmos = 0;
                try {
                    user_arithmos = Integer.parseInt(arithmos.getText().toString());
                } catch (NumberFormatException e) {
                    System.out.println("Could not parse " + e);
                }
                int id=0;
                int[] ids=new int[user_arithmos];
                for (int i = 0; i < user_arithmos; i++) {


                    txt[i] = new EditText(getActivity());
                    txt[i].setHint("Εισαγωγή αθλητή " + (i + 1));

                     id=View.generateViewId();
                     ids[i]=id;
                    txt[i].setId(id);




                    ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                            ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT
                    );


                    txt[i].setLayoutParams(params);

                    layout.addView(txt[i]);
                    constraintSet.clone(layout);
                    if(i==0)
                            constraintSet.connect(id,ConstraintSet.TOP,R.id.xwra_insert_agwna,ConstraintSet.BOTTOM,0);
                    else
                            constraintSet.connect(id,ConstraintSet.TOP,ids[i-1],ConstraintSet.BOTTOM,0);
                    constraintSet.connect(id,ConstraintSet.END,R.id.emfanisi_fields,ConstraintSet.END,0);
                    constraintSet.applyTo(layout);
                }
                Button btn=new Button(getActivity());
                btn.setText("Insert "+sport);
                id=View.generateViewId();
                btn.setId(id);
                btn.setBackgroundColor(getResources().getColor(R.color.mple));
                ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                        ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT
                );
                btn.setLayoutParams(params);
                btn.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        List<athlites> athlites=new ArrayList<athlites>();

                        int user_kwdikos=-1;
                        try {
                            user_kwdikos=Integer.parseInt(kwdikos.getText().toString());
                        }
                        catch (NumberFormatException e){
                            System.out.println("Could not parse " + e);
                        }
                        String user_hmeromhnia=hmeromhnia.getText().toString();
                        String user_poli=poli.getText().toString();
                        String user_xwra=xwra.getText().toString();


                        if(user_hmeromhnia.isEmpty() || user_poli.isEmpty() || user_xwra.isEmpty() || user_kwdikos==-1 || user_xwra.isEmpty()){
                            Toast.makeText(getActivity(), "Please insert all necessary fields!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            try {
                                Agwnes_Remote agwnas = new Agwnes_Remote();
                                agwnas.setAthlima(sport);
                                agwnas.setHmeromhnia(user_hmeromhnia);
                                agwnas.setId(user_kwdikos);
                                agwnas.setXwra(user_xwra);
                                agwnas.setPoli(user_poli);
                                agwnas.setArithmosAthlitwn(ids.length);
                                for( int i=0; i<ids.length;i++){
                                    athlites athltis=new athlites();
                                    EditText tmp=view.findViewById(ids[i]);
                                    athltis.setEpwnumo(tmp.getText().toString());
                                    athlites.add(athltis);

                                }
                                agwnas.setAthlites(athlites);
                                MainActivity.remote_db.collection("Atomikoi_Agwnes").document("" + user_kwdikos).set(agwnas).addOnCompleteListener(new OnCompleteListener<Void>() {
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
                        }
                        hmeromhnia.setText("");
                        poli.setText("");
                        xwra.setText("");
                        kwdikos.setText("");

                    }


                });
                layout.addView(btn);
                constraintSet.clone(layout);
                constraintSet.connect(id,ConstraintSet.TOP,ids[user_arithmos-1],ConstraintSet.BOTTOM,0);
                constraintSet.connect(id,ConstraintSet.END,R.id.emfanisi_fields,ConstraintSet.END,0);
                constraintSet.applyTo(layout);

            }

        });

        return view;

    }
}