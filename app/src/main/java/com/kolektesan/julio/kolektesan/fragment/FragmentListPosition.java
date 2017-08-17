package com.kolektesan.julio.kolektesan.fragment;
import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.persistence.DataQueryBuilder;
import com.backendless.property.ObjectProperty;
import com.kolektesan.julio.kolektesan.R;
import com.kolektesan.julio.kolektesan.activity.Details;
import com.kolektesan.julio.kolektesan.adapter.CentreAdapter;
import com.kolektesan.julio.kolektesan.model.Centre;
import com.kolektesan.julio.kolektesan.util.BackendlessSetting;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.kolektesan.julio.kolektesan.util.BackendlessSetting.APP_ID;
import static com.kolektesan.julio.kolektesan.util.BackendlessSetting.SECRET_KEY;

public class FragmentListPosition extends Fragment {

    ArrayList<Centre> centres;
    CentreAdapter adapter;
    ListView lvCentre;
   public Centre
            centre , centre2,
            centre3 , centre4,
            centre5 , centre6;
   public SwipeRefreshLayout swipeContainer;

    public FragmentListPosition() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_list_position, container, false);
        /*Backendless.setUrl( BackendlessSetting.SERVER_URL );
        Backendless.initApp(this, APP_ID, SECRET_KEY);*/

        /* Backendless.Persistence.describe( "Centre", new AsyncCallback<List<ObjectProperty>>() {
            @Override
            public void handleResponse(List<ObjectProperty> response) {
                Iterator<ObjectProperty> iterator = (Iterator<ObjectProperty>) response;
                while( iterator.hasNext() ){
                    ObjectProperty propDef = iterator.next();
                }
            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });*/

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
        toolbar.setTitle("Postion des centre de transfusion");

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
        adapter.add(centre);
        adapter.add(centre2);
        adapter.add(centre3);
        adapter.add(centre4);
        adapter.add(centre5);
        adapter.add(centre6);
    }

    public void fetchTimelineAsync(int page) {
       // adapter.clear();
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
