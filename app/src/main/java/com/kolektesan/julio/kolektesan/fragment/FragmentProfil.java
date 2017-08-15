package com.kolektesan.julio.kolektesan.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kolektesan.julio.kolektesan.R;
import com.kolektesan.julio.kolektesan.model.User;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProfil extends Fragment {
    public User user;
    public TextView tvVille;
    public TextView  tvGS;
    public TextView  tvTe;
    public TextView  tvQsang;
    public TextView tvAdresse;
    public EditText editTexttest;
    public Button btnFait;
 
    public FragmentProfil() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_profil, container, false);
        user = new User();
        user.setAdresse("Delmas 32 Port au Prince Haiti");
        user.setNom("Jean Fils Julio");
        user.setGroupSainguin("B+");
        user.setQteSan(16);
        user.setTelephone("+509.4818.8107");

        tvVille= (TextView)v.findViewById(R.id.tvVille);
        tvGS= (TextView)v.findViewById(R.id.tvGS);
        tvTe= (TextView)v.findViewById(R.id.tvTe);
        tvQsang= (TextView)v.findViewById(R.id.tvQsang);
        tvAdresse= (TextView)v.findViewById(R.id.tvAdresse);

      //  editTexttest= (EditText) v.findViewById(R.id.editTexttest);
        btnFait= (Button) v.findViewById(R.id.btnFait);

        btnFait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });



        tvVille.setText(user.getNom());
        tvGS.setText(user.getGroupSainguin());
        tvTe.setText(user.getTelephone());
        tvQsang.setText(user.getQteSan()+ " Grammes");
        tvAdresse.setText(user.getAdresse());

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Profil");

        return v;
    }

}
