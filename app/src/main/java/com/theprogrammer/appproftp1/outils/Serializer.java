package com.theprogrammer.appproftp1.outils;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Serializer implements Serializable {


    /**
     * serialisatio  d'un object
     * @param filename
     * @param object
     * @param context
     */
    public static void serialize(String filename, Object object , Context context) {
        
        try {
            FileOutputStream file = context.openFileOutput(filename, Context.MODE_PRIVATE);

            
            try {
                ObjectOutputStream oss = new ObjectOutputStream(file);
                oss.writeObject(object);
                oss.flush();
                oss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Object deserialize(String filename, Context context){

        try {
            FileInputStream file = context.openFileInput(filename);



            ObjectInputStream ois;

            try{
                     ois = new ObjectInputStream(file);

                         Object object = ois.readObject();
                         ois.close();
                         return object;


            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;

    }
}
