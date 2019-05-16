package com.theprogrammer.appproftp1.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProfilTest {

    //creation profil

    private  Profil profil = new Profil(67,165,35,0);
    //result IMG
    private float img =(float)32.2;
    //message

    private String message ="trop élevé";


    @Test
    public void setImg() {
         assertEquals(img,profil.getImg(),(float)0.1);
    }

    @Test
    public void setMessage() {

        assertEquals(message,profil.getMessage());
    }
}