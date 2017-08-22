package com.kolektesan.julio.kolektesan.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by carly.baja on 8/6/2017.
 */

public class Centre implements Serializable {
    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTrlrphone() {
        return trlrphone;
    }

    public void setTrlrphone(String trlrphone) {
        this.trlrphone = trlrphone;
    }

    public  String lieu;
    public  String img;
    public  String type;
    public  String trlrphone;


    public Centre (JSONObject jsonObject) throws JSONException {
        this.lieu = jsonObject.getString("lieu");
        this.trlrphone = jsonObject.getString("telephone");
       // this.img = jsonObject.getString("photo");
    }

    public static ArrayList<Centre> fromJSONArray(JSONArray array) {
        ArrayList<Centre> results = new ArrayList<>();
        for (int x = 0; x < array.length(); x++){
            try {
                results.add (new Centre(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
