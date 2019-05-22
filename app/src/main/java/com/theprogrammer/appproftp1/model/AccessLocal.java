package com.theprogrammer.appproftp1.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.theprogrammer.appproftp1.outils.MySQLITeOpenHelper;

import java.util.Date;

public class AccessLocal {


    private String nomBase ="bdCoach.sqlite";
    private Integer versionBase =1;
    private MySQLITeOpenHelper accessBD;
    private SQLiteDatabase bd;

    public AccessLocal(Context context) {

        accessBD = new MySQLITeOpenHelper(context,nomBase,null,versionBase);


    }


    /***
     * ajout d'un profil dans la base de donnée
     * @param profil
     */
    public void ajout(Profil profil) {
        bd = accessBD.getWritableDatabase();
        String req = "insert into  profil (datemusure, poids,taille, age, sexe)  value";
        req += "(\""+profil.getDateMesure()+"\","+profil.getPoids()+","+profil.getTailes()+","+profil.getAge()+","+profil.getAge()+")";


        bd.execSQL(req);

    }

    /**
     * recuperation du dernier profil de la bd
     * @return
     */

    public Profil recupDernier() {

        bd = accessBD.getReadableDatabase();
        Profil profil = null;
        String req = "select * from profil";
        Cursor curseur = bd.rawQuery(req,null);

        curseur.moveToLast();

        if (!curseur.isAfterLast()) {


            Date date = new Date();
            Integer poids = curseur.getInt(1);
            Integer taille = curseur.getInt(2);
            Integer age = curseur.getInt(3);
            Integer sexe = curseur.getInt(4);
            profil = new Profil(date, poids, taille, age, sexe);
        }

        curseur.close();
        return profil;

    }
}
