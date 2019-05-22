package com.theprogrammer.appproftp1.outils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLITeOpenHelper extends SQLiteOpenHelper {

//    propriété

    private String creation ="create table profil ( datemesure TEXT primary key, " +
            "poids integer not null, " +
            "taille integer not null," +
            " age integer not null ," +
            " sexe integer not null)";
    /**
     * constructeur
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public MySQLITeOpenHelper(@androidx.annotation.Nullable Context context, @androidx.annotation.Nullable String name, @androidx.annotation.Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * si y'a changement de bd
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(creation);
    }

    /**
     * Si changement de version
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
