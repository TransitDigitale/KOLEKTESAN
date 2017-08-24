package com.kolektesan.julio.kolektesan.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kolektesan.julio.kolektesan.R;
import com.kolektesan.julio.kolektesan.model.Demande;
import com.kolektesan.julio.kolektesan.model.Statistique;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.kolektesan.julio.kolektesan.R.id.imageView;

/**
 * Created by Julio on 7/21/2016.
 */
public class DemandeAdapter extends ArrayAdapter<Demande> {
    public DemandeAdapter(Context context, List<Demande> demandes) {
        super(context, android.R.layout.simple_list_item_1,demandes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // return super.getView(position, convertView, parent);
        Demande demande = this.getItem(position);

        if (convertView == null){
            LayoutInflater inflater= LayoutInflater.from(getContext());
           convertView = inflater.inflate(R.layout.item_demande,parent,false);
        }
        // find the image view
         ImageView imageView = (ImageView) convertView.findViewById(R.id.ivlocal);
        // Clear the recycle image from convertView from last time
        // imageView.setImageResource(0);
        TextView tvVille = (TextView) convertView.findViewById(R.id.tvVille);
        TextView tvAdresse = (TextView) convertView.findViewById(R.id.tvAdresse);
        TextView tvType = (TextView) convertView.findViewById(R.id.tvType);
        TextView tvQte = (TextView) convertView.findViewById(R.id.tvQte);

        tvVille.setText(demande.getName());
        tvAdresse.setText(demande.getText());
        tvQte.setText(demande.getQte() + " Grammes");
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

        try {
            Date date = format.parse(demande.getDate());
            tvType.setText(""+ date);
        } catch (ParseException e) {
            e.printStackTrace();
            tvType.setText(demande.getDate());
        };

        // populate the thumbNail images
        // remote download image in background
        String thumbNail = demande.getQte();
        if(!TextUtils.isEmpty(thumbNail)){
             Picasso.with(getContext()).load(thumbNail).placeholder(R.drawable.ic_action_person) .into(imageView);
        }
        return convertView;
    }
}
