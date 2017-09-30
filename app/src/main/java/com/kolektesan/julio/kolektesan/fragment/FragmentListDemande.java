package com.kolektesan.julio.kolektesan.fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kolektesan.julio.kolektesan.R;
import com.kolektesan.julio.kolektesan.adapter.DemandeAdapter;
import com.kolektesan.julio.kolektesan.model.Demande;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class FragmentListDemande extends Fragment {

    ArrayList<Demande> demandeArrayList;
    DemandeAdapter adapter;
    ListView lvCentre;
    ProgressBar progressBar;
    public SwipeRefreshLayout swipeContainer;

    public FragmentListDemande() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_list_position, container, false);

        adapter.notifyDataSetChanged();

        lvCentre = (ListView) v.findViewById(R.id.lvCentre);
        progressBar = (ProgressBar) v.findViewById(R.id.progressBar);

        demandeArrayList = new ArrayList<>();
        adapter = new DemandeAdapter(getContext(), demandeArrayList);
        lvCentre.setAdapter(adapter);

      /*  lvCentre.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Demande details = demandeArrayList.get(i);
                Intent intent = new Intent(getContext(), Details.class);
                intent.putExtra("details", (Serializable) details);
                startActivity(intent);
            }
        });*/

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
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Demande urgence");
        return v;
    }

    public void fetchTimelineAsync(int page) {
        adapter.clear();
        findStat();
        swipeContainer.setRefreshing(false);
    }

    public void findStat() {
        String url = "https://shareblood.herokuapp.com/api/alerts/";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                JSONArray jobJsonPosts = response;
                demandeArrayList.addAll(Demande.fromJSONArray(jobJsonPosts));
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

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        demandeArrayList  = new ArrayList<>();
        adapter = new DemandeAdapter(getActivity(),demandeArrayList);
    }
}
