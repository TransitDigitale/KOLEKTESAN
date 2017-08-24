package com.kolektesan.julio.kolektesan.fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kolektesan.julio.kolektesan.R;
import com.kolektesan.julio.kolektesan.activity.Details;
import com.kolektesan.julio.kolektesan.adapter.CentreAdapter;
import com.kolektesan.julio.kolektesan.model.Centre;

import java.io.Serializable;
import java.util.ArrayList;

public class FragmentListDemande extends Fragment {

    ArrayList<Centre> centres;
    CentreAdapter adapter;
    ListView lvCentre;
   public Centre
            centre , centre2,
            centre3 , centre4,
            centre5 , centre6;
   public SwipeRefreshLayout swipeContainer;

    public FragmentListDemande() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_list_position, container, false);
     
        lvCentre = (ListView) v.findViewById(R.id.lvCentre);
        findList();
        lvCentre.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Centre details = centres.get(i);
                Intent intent = new Intent(getContext(), Details.class);
                intent.putExtra("details", (Serializable) details);
                startActivity(intent);
            }
        });

        //adapter.notifyDataSetChanged();

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Demande de sang en urgence");

        swipeContainer = (SwipeRefreshLayout)v.findViewById(R.id.swipeContainer);
        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                fetchTimelineAsync(0);
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        return v;
    }

    public void findList() {
        centres = new ArrayList<>();
        adapter = new CentreAdapter(getContext(), centres);
        lvCentre.setAdapter(adapter);
    }

    public void fetchTimelineAsync(int page) {
        adapter.clear();
        swipeContainer.setRefreshing(false);
    }

  

    /*
        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
            toolbar.setTitle("Liste de postion");
        }
    */

}
