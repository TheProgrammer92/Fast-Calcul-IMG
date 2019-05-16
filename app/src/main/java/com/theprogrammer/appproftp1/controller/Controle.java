package com.theprogrammer.appproftp1.controller;

import com.theprogrammer.appproftp1.model.Profil;

public final class Controle {

    private static Controle instance = null;
    private Profil profil;

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
    public static final Controle getInstance() {

        if (Controle.instance ==null) {

            Controle.instance = new Controle();
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
    public void creerProfil(Integer poids , Integer taille, Integer age, Integer sexe) {
        profil = new Profil(poids, taille,age, sexe);

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
}
