package com.kolektesan.julio.kolektesan;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListPosition extends Fragment {

    RelativeLayout one,two;
    public FragmentListPosition() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_list_position, container, false);
        one = (RelativeLayout) v.findViewById(R.id.one);
        two = (RelativeLayout) v.findViewById(R.id.two);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( getContext(), Details.class);
                startActivity(i);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( getContext(), Details.class);
                startActivity(i);
            }
        });

        return v;
    }


}
