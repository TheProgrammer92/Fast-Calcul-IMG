package com.theprogrammer.appproftp1.model;

public class Profil {


    //constante

    private static final Integer minFemme =15;
    private static final Integer maxFemme =15;
    private static final Integer minHomme =15;
    private static final Integer maxHomme =15;

     //propriété
    private Integer poids;
    private Integer taille;
    private Integer age;
    private Integer sexe;
    private float img;
    private String message;


    public Profil(Integer poids, Integer tailles, Integer age, Integer sexe) {

        this.poids = poids;
        this.taille = tailles;
        this.age = age;
        this.sexe = sexe;

        this.calculIMG();
        this.resultIMG();
    }

    public float getImg() {
        return img;
    }

    public void setImg(float img) {
        this.img = img;
    }

    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    public Integer getTailes() {
        return taille;
    }

    public void setTailes(Integer tailes) {
        this.taille = tailes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSexe() {
        return sexe;
    }

    public void setSexe(Integer sexe) {
        this.sexe = sexe;
    }




    private void calculIMG() {
        float tailleM = ((float) taille)/100;
        this.img = (float) ((1.2*poids/(tailleM*tailleM)) + (0.23 * age) - (10.83*sexe) - 5.4);
    }

    private void resultIMG() {
        Integer min;
        Integer max;


        if (sexe==0) { // c'est une femme

            min = minFemme;
            max = maxFemme;
        }
        else{ //c'est un homme
            min = minHomme;
            max= maxHomme;
        }

        //message correspondant
        message ="normal";
       if (img<min) {

           message = "trop faible";

       }
       else {

           if (img>max) {
               message = "trop élevé";
           }
       }
    }
}
