package com.kolektesan.julio.kolektesan.model;

import java.io.Serializable;

/**
 * Created by carly.baja on 8/6/2017.
 */

public class Pub implements Serializable {
    public int getAudioLink() {
        return audioLink;
    }

    public void setAudioLink(int audioLink) {
        this.audioLink = audioLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgCover() {
        return imgCover;
    }

    public void setImgCover(String imgCover) {
        this.imgCover = imgCover;
    }
    public int audioLink;
    public  String name;
    public  String type;
    public  String imgCover;

/*
    public Pub(JSONObject jsonObject) throws JSONException {
        this.name = jsonObject.getString("name");
        this.type = jsonObject.getString("type");
        this.imgCover = jsonObject.getString("imgCover");
        this.audioLink = jsonObject.getInt("audioLink");
    }

    public static ArrayList<Pub> fromJSONArray(JSONArray array) {
        ArrayList<Pub> results = new ArrayList<>();
        for (int x = 0; x < array.length(); x++){
            try {
                results.add (new Pub(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }*/

}
