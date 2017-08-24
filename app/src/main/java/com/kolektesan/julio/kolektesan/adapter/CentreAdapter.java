package com.kolektesan.julio.kolektesan.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.backendless.property.ObjectProperty;
import com.kolektesan.julio.kolektesan.R;
import com.kolektesan.julio.kolektesan.model.Centre;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julio on 7/21/2016.
 */
public class CentreAdapter extends ArrayAdapter<Centre> {
    public CentreAdapter(Context context, List<Centre> centres) {
        super(context, android.R.layout.simple_list_item_1,centres);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // return super.getView(position, convertView, parent);
        Centre centre = this.getItem(position);

        if (convertView == null){
            LayoutInflater inflater= LayoutInflater.from(getContext());
           convertView = inflater.inflate(R.layout.item_centre,parent,false);
        }
        // find the image view
        // ImageView imageView = (ImageView) convertView.findViewById(R.id.ivlocal);
        // Clear the recycle image from convertView from last time
        //imageView.setImageResource(0);
        TextView tvVille = (TextView) convertView.findViewById(R.id.tvVille);
        TextView tvAdresse = (TextView) convertView.findViewById(R.id.tvAdresse);
        TextView tvType = (TextView) convertView.findViewById(R.id.tvType);

        tvVille.setText(centre.getLieu());
        tvAdresse.setText(centre.getTrlrphone());
        tvType.setText(centre.getTypee());

        // populate the thumbNail images
        // remote download image in background
        String thumbNail = centre.getImg();
        if(!TextUtils.isEmpty(thumbNail)){
        //    Picasso.with(getContext()).load(thumbNail).into(imageView);
        }
        return convertView;
    }
}
