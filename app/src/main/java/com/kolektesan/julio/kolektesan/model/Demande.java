package com.kolektesan.julio.kolektesan.model;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by carly.baja on 8/6/2017.
 */

public class Demande implements Serializable {


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getQte() {
        return qte;
    }

    public void setQte(String qte) {
        this.qte = qte;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String name;
    public  String text;
    public  String qte;
    public  String date;
    public  String etat;

    // public  User user;

    public Demande(JSONObject jsonObject) throws JSONException {
        this.text = jsonObject.getString("text");
        this.date = jsonObject.getString("etat");
        this.qte = jsonObject.getString("qte");
        this.etat = jsonObject.getString("text");
        this.name = jsonObject.getString("etat");
        // this.img = jsonObject.getString("photo");
    }

    public static ArrayList<Demande> fromJSONArray(JSONArray array) {
        ArrayList<Demande> results = new ArrayList<>();
        for (int x = 0; x < array.length(); x++){
            try {
                results.add (new Demande(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

}
