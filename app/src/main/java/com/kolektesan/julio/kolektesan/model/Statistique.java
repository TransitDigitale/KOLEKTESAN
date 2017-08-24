package com.kolektesan.julio.kolektesan.model;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by carly.baja on 8/6/2017.
 */

public class Statistique implements Serializable {


    public String getCritere() {
        return critere;
    }

    public void setCritere(String critere) {
        this.critere = critere;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(String pourcentage) {
        this.pourcentage = pourcentage;
    }

    public  String critere;
    public String date;
    public  String pourcentage;

    public Statistique(JSONObject jsonObject) throws JSONException {
        this.critere = jsonObject.getString("critere");
        this.date = jsonObject.getString("date");
        this.pourcentage = jsonObject.getString("pourcentage");
        // this.img = jsonObject.getString("photo");
    }

    public static ArrayList<Statistique> fromJSONArray(JSONArray array) {
        ArrayList<Statistique> results = new ArrayList<>();
        for (int x = 0; x < array.length(); x++){
            try {
                results.add (new Statistique(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

}
