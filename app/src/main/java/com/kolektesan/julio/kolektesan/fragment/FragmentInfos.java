package com.kolektesan.julio.kolektesan.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.kolektesan.julio.kolektesan.R;
import com.kolektesan.julio.kolektesan.adapter.CentreAdapter;
import com.kolektesan.julio.kolektesan.model.Centre;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentInfos extends Fragment {

    ArrayList<Centre> centres;
    CentreAdapter adapter;
    ListView lvCentre;
    public Centre
            centre , centre2,
            centre3 , centre4,
            centre5 , centre6;

    public FragmentInfos() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_list_position, container, false);

        centre = new Centre();
        centre.setLieu("Kantite pochet moun rive bay");
        centre.setTrlrphone("25963 moun");
        centre.setType("");

        centre2 = new Centre();
        centre2.setLieu("Pousantaj pochet san nou rive pwodwi");
        centre2.setTrlrphone("64,91% moun");
        centre2.setType("");

        centre3 = new Centre();
        centre3.setLieu("Kantite pochet san moun bliye bay");
        centre3.setTrlrphone("20691 moun");
        centre3.setType("");

        centre4 = new Centre();
        centre4.setLieu("Kantite pochet san nou mande pou malad");
        centre4.setTrlrphone("50977 moun");
        centre4.setType("");

        centre5 = new Centre();
        centre5.setLieu("Pousantaj moun ki rive jwenn san le yo bezwen");
        centre5.setTrlrphone("55,88% moun");
        centre5.setType("");


        lvCentre = (ListView) v.findViewById(R.id.lvCentre);

       /*
        lvCentre.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Centre details = centres.get(i);
                Intent intent = new Intent(getContext(), Details.class);
                intent.putExtra("details",details);
                startActivity(intent);
            }
        });
        */

        centres = new ArrayList<>();
        adapter = new CentreAdapter(getContext(), centres);
        lvCentre.setAdapter(adapter);
        adapter.add(centre);
        adapter.add(centre2);
        adapter.add(centre3);
        adapter.add(centre4);
        adapter.add(centre5);

        adapter.notifyDataSetChanged();
        return v;
    }


}
