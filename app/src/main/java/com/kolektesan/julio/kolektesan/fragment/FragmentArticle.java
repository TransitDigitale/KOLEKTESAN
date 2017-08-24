package com.kolektesan.julio.kolektesan.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
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
public class FragmentArticle extends Fragment {

    ArrayList<Centre> centres;
    CentreAdapter adapter;
    ListView lvCentre;
    public Centre
            centre , centre2,
            centre3 , centre4,
            centre5 , centre6;

    public FragmentArticle() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_list_position, container, false);
/*
        centre = new Centre();
        centre.setLieu("Men kek prensip bay san");
        centre.setTrlrphone("youn nan prensip bay san san se vonlonte , ki vle di moun kap bay san an fe sa paske li vle" +
                "se li men m ki deside fe jes la yon manye pou rive sove lavi");
        centre.setType("");

        centre2 = new Centre();
        centre2.setLieu("Nan yon kolek koman sa pase");
        centre2.setTrlrphone("Apre w fin rive , yon pwomote gen pou l eskeplike tout koman sa pral pase ,L'ap" +
                "baw yon kestyone , ki gen ladann l yon latriye kestyon ki pral pemet  mis lan gen bon jan enfomasyon sou santew . kpoteman w , laj ou ak lot anko ." +
                "Le w fini ranpli kestyone a , epa gen pou fe  yon seri tes kipral  pemet yo kontrole w" +
                "" +
                "tes kipral  pemet yo kontrole w" +
                "Apre w fin rive , yon pwomote gen pou l eskeplike tout koman sa pral pase ,L'ap" +
                "baw yon kestyone , ki gen ladann l yon latriye kestyon ki pral pemet  mis lan gen bon jan enfomasyon sou santew . kpoteman w , laj ou ak lot anko ." +
                "Le w fini ranpli kestyone a , epa gen pou fe  yon seri tes kipral  pemet yo kontrole w" +
                "" +
                "tes kipral  pemet yo kontrole w" +
                "" +
                " ki gen ladann l yon latriye kestyon ki pral pemet  mis lan gen bon jan enfomasyon sou santew . kpoteman w , laj ou ak lot anko ." +
                "Le w fini ranpli kestyone a , epa gen pou fe  yon seri tes kipral  pemet yo kontrole");
        centre2.setType("");



        centre3 = new Centre();
        centre3.setLieu("Kisa nou fe ak san an ");
        centre3.setTrlrphone("Le w bay san w , san lan al nan laboratwa , "
                + "apre tout tes pou" + " kontrowole maladi" +
                " ,sanw bay la ki rele san total separe pou l bay :"
                + "yon premye pati ki sa konsantman globil wouj ale nan yon poch ");
        centre3.setType("");

        lvCentre = (ListView) v.findViewById(R.id.lvCentre);

        lvCentre.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Centre details = centres.get(i);
                Intent intent = new Intent(getContext(), ScrollingActivityDetailArticle.class);
                intent.putExtra("details",details);
                startActivity(intent);
            }
        });

        centres = new ArrayList<>();
        adapter = new CentreAdapter(getContext(), centres);
        lvCentre.setAdapter(adapter);
        adapter.add(centre);
        adapter.add(centre2);
        adapter.add(centre3);*/
        adapter.notifyDataSetChanged();
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Liste des articles fragment article");
        return v;
    }

  /*  @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Liste des articles");
    }*/
}
