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
import android.widget.Toast;

import com.kolektesan.julio.kolektesan.R;
import com.kolektesan.julio.kolektesan.activity.Details;
import com.kolektesan.julio.kolektesan.adapter.CentreAdapter;
import com.kolektesan.julio.kolektesan.model.Centre;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListPosition extends Fragment {

    ArrayList<Centre> ListCentres;
    CentreAdapter adapter;
    ListView lvCentre;
    public Centre
            centre;
   public SwipeRefreshLayout swipeContainer;

    public FragmentListPosition() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_list_position, container, false);

        lvCentre = (ListView) v.findViewById(R.id.lvCentre);

        lvCentre = (ListView) v.findViewById(R.id.lvCentre);
        ListCentres = new ArrayList<>();
        adapter = new CentreAdapter(getContext(), ListCentres);

        lvCentre.setAdapter(adapter);

        lvCentre.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Centre details = ListCentres.get(i);
                Intent intent = new Intent(getContext(), Details.class);
                intent.putExtra("details",details);
                startActivity(intent);
            }
        });

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
                findArticle();
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        findArticle();
        return v;


    }
    public void fetchTimelineAsync(int page) {
        adapter.clear();
        // findArticle();
        swipeContainer.setRefreshing(false);
    }

    public void findArticle() {
        String url = "https://shareblood.herokuapp.com/api/centres";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                JSONArray jobJsonPosts = response;
                ListCentres.addAll(Centre.fromJSONArray(jobJsonPosts));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(getContext(), "Error " + errorResponse.toString() , Toast.LENGTH_SHORT).show();
            }
        });
        /*
        client.get(url, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, PreferenceActivity.Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                JSONArray jobJsonPosts = response;
                // jobJsonPosts = response;
                ListCentres.addAll(Centre.fromJSONArray(jobJsonPosts));
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Test result " + jobJsonPosts.toString() , Toast.LENGTH_SHORT).show();
                Log.d("DEBUG", jobJsonPosts.toString() );
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(getContext(), "test result " +errorResponse.toString() , Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ListCentres  = new ArrayList<>();
        adapter = new CentreAdapter(getActivity(),ListCentres);
    }

    public void addAll(List<Centre> offres){
        adapter.addAll(offres);
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
