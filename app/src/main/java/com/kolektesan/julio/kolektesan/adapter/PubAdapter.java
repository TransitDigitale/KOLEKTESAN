package com.kolektesan.julio.kolektesan.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kolektesan.julio.kolektesan.R;
import com.kolektesan.julio.kolektesan.model.Pub;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Julio on 7/21/2016.
 */
public class PubAdapter extends ArrayAdapter<Pub> {
    public   MediaPlayer mediaPlayer;
    public PubAdapter(Context context, ArrayList<Pub> centres) {
        super(context, android.R.layout.simple_list_item_1,centres);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // return super.getView(position, convertView, parent);
        final Pub pub = this.getItem(position);
        int type = getItemViewType(position);


        if (convertView == null){
            LayoutInflater inflater= LayoutInflater.from(getContext());
            //Inflate the XML layout based on the type
            convertView = getInflatedLayoutForType(type);
            //on sait pas encore quel view va etre inflate
             // convertView = inflater.inflate(R.layout.item_pu,parent,false);
        }
        ///find the image view
        //ImageView imageView = (ImageView) convertView.findViewById(R.id.ivlocal);
        // Clear the recycle image from convertView from last time
        //imageView.setImageResource(0);
        TextView tvVille = (TextView) convertView.findViewById(R.id.tvVille);
        TextView tvAdresse = (TextView) convertView.findViewById(R.id.tvAdresse);
        TextView tvType = (TextView) convertView.findViewById(R.id.tvType);
        ImageView imagecorver = (ImageView) convertView.findViewById(R.id.corver);

        final int res = pub.getAudioLink();
        mediaPlayer = MediaPlayer.create(getContext(),res);
        final ImageView play = (ImageView) convertView.findViewById(R.id.btnPlay);
        final ImageView pause = (ImageView) convertView.findViewById(R.id.btnPause);

        tvVille.setText(pub.getName());
        tvAdresse.setText(pub.getType());

        /*play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pub.getType().equals("videos")){

                }
                {
                    mediaPlayer.start();
                }
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int res = Integer.parseInt(("R.raw."+pub.getAudioLink()));
                //mediaPlayer = MediaPlayer.create(getContext(),R.raw.baysan);
                mediaPlayer.pause();
                // mediaPlayer.stop();
            }
        });*/

        // tvType.setText(tu.getType());
        // populate the thumbNail images
        // remote download image in background
        String thumbNail = pub.getImgCover();
        if(!TextUtils.isEmpty(thumbNail)){
               Picasso.with(getContext()).load(thumbNail).into(imagecorver);
        }
        return convertView;
    }

    private View getInflatedLayoutForType(int type) {
        if (type == 1) {
            return LayoutInflater.from(getContext()).inflate(R.layout.item_pu_videos, null);
        } else if (type == 0) {
            return LayoutInflater.from(getContext()).inflate(R.layout.item_pu, null);
        } else {
            return LayoutInflater.from(getContext()).inflate(R.layout.item_pu, null);
        }
    }

    //Return int for the type according to popularity of movie (1 or 0)
    @Override
    public int getItemViewType(int position) {
        //return 1 if movie is popular, or 0 if not
        //si getType est vidoes alors return 1 for the else return 0
        return getItem(position).getType().equals("videos") ? 1 : 0;
    }

    //Total number of type is 2 (popular an non-popular)
    @Override
    public int getViewTypeCount() {
        return 1;
    }
}
