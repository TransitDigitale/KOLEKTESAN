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
import android.widget.ProgressBar;

import com.kolektesan.julio.kolektesan.R;
import com.kolektesan.julio.kolektesan.activity.PlayerMusic;
import com.kolektesan.julio.kolektesan.activity.PlayerVideos;
import com.kolektesan.julio.kolektesan.adapter.PubAdapter;
import com.kolektesan.julio.kolektesan.model.Pub;

import java.util.ArrayList;

import static com.kolektesan.julio.kolektesan.R.id.lvCentre;

/**
 * A simple {@link Fragment} subclass.
 */
public class PubFragment extends Fragment {

    ArrayList<Pub> PubList;
    PubAdapter adapter;
    ListView lvPub;
    ProgressBar progressBar;
    public Pub
            pub , pub1,
            pub2 ;
    SwipeRefreshLayout swipeContainer;

    public PubFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_list_position, container, false);

        pub = new Pub();
        pub.setAudioLink(R.raw.donsan);
        pub.setName("Vin fe don san ");
        pub.setType("music");


        pub1 = new Pub();
        pub1.setAudioLink(R.raw.videos);
        pub1.setName("Enpotans san ");
        pub1.setType("music");

        pub2 = new Pub();
        pub2.setAudioLink(R.raw.baysan);
        pub2.setName("Vin bay san ");
        pub2.setType("music");
        /*
        pub2 = new Pub();
        pub2.setAudioLink("jingle");
        pub2.setName("Sove yon vi ");
        pub2.setType("Autio");
        */

        swipeContainer = (SwipeRefreshLayout)v.findViewById(R.id.swipeContainer);
        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                fetchTimelineAsync(0);
                // findStat();
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        progressBar = (ProgressBar) v.findViewById(R.id.progressBar);

        progressBar.setVisibility(View.GONE);

        lvPub = (ListView) v.findViewById(lvCentre);
        lvPub.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pub playpub = PubList.get(i);
                if(playpub.getType().equals("videos")){
                    Intent intent = new Intent(getContext(), PlayerVideos.class);
                    intent.putExtra("playpub", playpub);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(getContext(), PlayerMusic.class);
                    intent.putExtra("playpub", playpub);
                    startActivity(intent);
                }
            }
        });

        PubList = new ArrayList<>();
        adapter = new PubAdapter(getContext(), PubList);

        lvPub.setAdapter(adapter);
        adapter.add(pub);
        adapter.add(pub1);
        adapter.add(pub2);
        adapter.notifyDataSetChanged();

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Sensibilisations");
        return v;
    }

    public void fetchTimelineAsync(int page) {
        adapter.clear();

        swipeContainer.setRefreshing(false);
    }
}
/*

public class PubFragment extends Fragment {

    ArrayList<Pub> PubList;
    PubAdapter adapter;
    ListView lvPub;
    public Pub
    pub , pub1,
    pub2 ;
    public SwipeRefreshLayout swipeContainer;
    ProgressBar progressBar;
    public PubFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_list_position, container, false);


        lvPub = (ListView) v.findViewById(lvCentre);
        lvPub.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pub playpub = PubList.get(i);
                String t  = playpub.getType();
                if(t.equals("videos")){
                    Intent intent = new Intent(getContext(), PlayerVideos.class);
                    intent.putExtra("playpub", playpub);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(getContext(), PlayerMusic.class);
                    intent.putExtra("playpub", playpub);
                    startActivity(intent);
                }
            }
        });

        PubList = new ArrayList<>();
        adapter = new PubAdapter(getContext(), PubList);

        lvPub.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        progressBar = (ProgressBar) v.findViewById(R.id.progressBar);

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Sensibilisations");
        swipeContainer = (SwipeRefreshLayout)v.findViewById(R.id.swipeContainer);
        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                fetchTimelineAsync(0);
                // findStat();
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        findStat();
        return v;
    }
    public void fetchTimelineAsync(int page) {
        adapter.clear();
        findStat();
        swipeContainer.setRefreshing(false);
    }

    public void findStat() {
        String url = "https://shareblood.herokuapp.com/api/publicites";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                JSONArray jobJsonPosts = response;
                PubList.addAll(Pub.fromJSONArray(jobJsonPosts));
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(getContext(), "Error " + errorResponse.toString() , Toast.LENGTH_SHORT).show();
            }
        });
    }

}
*/
