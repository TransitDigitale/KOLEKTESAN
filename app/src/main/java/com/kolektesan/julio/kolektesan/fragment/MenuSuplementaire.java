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
import com.kolektesan.julio.kolektesan.activity.PlayerMusic;
import com.kolektesan.julio.kolektesan.adapter.PubAdapter;
import com.kolektesan.julio.kolektesan.model.Pub;

import java.util.ArrayList;

import static com.kolektesan.julio.kolektesan.R.id.lvCentre;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuSuplementaire extends Fragment {

    ArrayList<Pub> PubList;
    PubAdapter adapter;
    ListView lvPub;
    public Pub
    pub , pub1,
    pub2 ;

    public MenuSuplementaire() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_list_position, container, false);

        pub = new Pub();
        pub.setAudioLink(R.raw.baysan);
        pub.setName("Vin bay san ");
        pub.setType("Autio");


        pub1 = new Pub();
        pub1.setAudioLink(R.raw.donsan);
        pub1.setName("Vin bay san ");
        pub1.setType("Autio");

        /*
        pub2 = new Pub();
        pub2.setAudioLink("jingle");
        pub2.setName("Sove yon vi ");
        pub2.setType("Autio");
        */

        lvPub = (ListView) v.findViewById(lvCentre);
        lvPub.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pub playpub = PubList.get(i);
                Intent intent = new Intent(getContext(), PlayerMusic.class);
                intent.putExtra("playpub",playpub);
                startActivity(intent);
            }
        });

        PubList = new ArrayList<>();
        adapter = new PubAdapter(getContext(), PubList);

        lvPub.setAdapter(adapter);
        adapter.add(pub);
        adapter.notifyDataSetChanged();
        return v;
    }


}
