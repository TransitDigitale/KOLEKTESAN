package com.kolektesan.julio.kolektesan.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kolektesan.julio.kolektesan.R;
import com.kolektesan.julio.kolektesan.activity.Details;
import com.kolektesan.julio.kolektesan.adapter.CentreAdapter;
import com.kolektesan.julio.kolektesan.model.Centre;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListPosition extends Fragment {

    ArrayList<Centre> centres;
    CentreAdapter adapter;
    ListView lvCentre;
    public Centre
            centre , centre2,
            centre3 , centre4,
            centre5 , centre6;

    public FragmentListPosition() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_list_position, container, false);

        centre = new Centre();
        centre.setLieu("Port au prince");
        centre.setTrlrphone("+509 22888800");
        centre.setType("PTS");

        centre2 = new Centre();
        centre2.setLieu("Jacmel");
        centre2.setTrlrphone("+509 22888822");
        centre2.setType("DDS");

        centre3 = new Centre();
        centre3.setLieu("Port de Paix");
        centre3.setTrlrphone("+509 22888892");
        centre3.setType("DDS");

        centre4 = new Centre();
        centre4.setLieu("Geremie");
        centre4.setTrlrphone("+509 22880022");
        centre4.setType("PTS");

        centre5 = new Centre();
        centre5.setLieu("Gonaives");
        centre5.setTrlrphone("+509 33888822");
        centre5.setType("PTS");

        centre6 = new Centre();
        centre6.setLieu("Hinche");
        centre6.setTrlrphone("+50942888822");
        centre6.setType("DDS");

        lvCentre = (ListView) v.findViewById(R.id.lvCentre);
        lvCentre.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Centre details = centres.get(i);
                Intent intent = new Intent(getContext(), Details.class);
                intent.putExtra("details",details);
                startActivity(intent);
            }
        });

        centres = new ArrayList<>();
        adapter = new CentreAdapter(getContext(), centres);
        lvCentre.setAdapter(adapter);
        adapter.add(centre);
        adapter.add(centre2);
        adapter.add(centre3);
        adapter.add(centre4);
        adapter.add(centre5);
        adapter.add(centre6);

        adapter.notifyDataSetChanged();
        return v;
    }


}
