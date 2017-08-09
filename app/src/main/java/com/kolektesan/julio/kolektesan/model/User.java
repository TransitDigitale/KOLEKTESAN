package com.kolektesan.julio.kolektesan.model;

/**
 * Created by carly.baja on 8/6/2017.
 */

public class User {
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGroupSainguin() {
        return groupSainguin;
    }

    public void setGroupSainguin(String groupSainguin) {
        this.groupSainguin = groupSainguin;
    }

    public int getQteSan() {
        return qteSan;
    }

    public void setQteSan(int qteSan) {
        this.qteSan = qteSan;
    }

    public String nom;
    public String adresse;
    public String telephone;
    public String groupSainguin;
    public int qteSan;
}
