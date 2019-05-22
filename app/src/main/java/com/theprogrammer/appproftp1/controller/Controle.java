package com.theprogrammer.appproftp1.controller;

import android.content.Context;

import com.theprogrammer.appproftp1.model.AccessLocal;
import com.theprogrammer.appproftp1.model.Profil;
import com.theprogrammer.appproftp1.outils.Serializer;

import java.io.Serializable;
import java.util.Date;

public final class Controle {

    private static Controle instance = null;
    private static Profil profil;
    private static String nomFic = "saveprofil";
    private static AccessLocal accessLocal;

    /**
     *private constructor
     */
    private Controle() {

        super();
    }

    /**
     * creation de l'instance
     * @return instance
     */
    public static final Controle getInstance(Context context) {

        if (Controle.instance ==null) {

            Controle.instance = new Controle();
            accessLocal = new AccessLocal(context);
            profil = accessLocal.recupDernier();

//            recupSerialize(context);

        }

        return Controle.instance;
    }

    /**
     * creation du profil
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe 1 pour homme et 0 pour femme
     */
    public void creerProfil(Integer poids , Integer taille, Integer age, Integer sexe, Context context) {
        profil = new Profil(new Date(),poids, taille,age, sexe);
        accessLocal.ajout(profil);

//        Serializer.serialize(nomFic, profil,context);

    }



    /**
     * recuperation img profil
     * @return img
     */
    public float getImg() {
        return profil.getImg();
    }

    /**
     * recuperation message de profil
     * @return message
     */
    public String getMessage() {
        return profil.getMessage();
    }

    private static void recupSerialize(Context context) {


        profil = (Profil) Serializer.deserialize(nomFic, context);
    }

    public Integer getPoids () {


        if (profil ==null) {

            return null;
        }

        else {
            return profil.getPoids();
        }
    }

    public Integer getTaille() {

        if (profil ==null) {
            return null;
        }
        else {
            return profil.getTailes();
        }
    }

    public Integer getAge() {

        if (profil == null) {
            return null;
        }

        else {
            return profil.getAge();
        }
    }
    public Integer getSexe() {
        if (profil == null) {
            return null;
        }

        else {
            return profil.getSexe();
        }
    }

}
