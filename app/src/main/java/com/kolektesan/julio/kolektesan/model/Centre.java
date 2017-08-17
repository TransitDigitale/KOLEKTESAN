package com.kolektesan.julio.kolektesan.model;

import com.backendless.property.ObjectProperty;

import java.io.Serializable;

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

    public String getTypee() {
        return typee;
    }

    public void setType(String type) {
        this.typee = type;
    }

    public String getTrlrphone() {
        return trlrphone;
    }

    public void setTrlrphone(String trlrphone) {
        this.trlrphone = trlrphone;
    }

    public  String lieu;
    public  String img;
    public  String typee;
    public  String trlrphone;
}
