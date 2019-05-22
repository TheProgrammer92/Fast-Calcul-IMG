package com.theprogrammer.appproftp1.vue;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.theprogrammer.appproftp1.R;
import com.theprogrammer.appproftp1.controller.Controle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


    }

    //propriété

    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private RadioButton rdFemme;
    private TextView lblIMG;
    private ImageView imgSmiley;
    private Controle controle;
    private Button btnCalc;

    /***
     * initialisation des liens avec des object graphiques
     */

    private void init() {
        txtPoids = findViewById(R.id.txtPoids);
        txtTaille = findViewById(R.id.txtTaile);
        txtAge = findViewById(R.id.txtAge);
        rdHomme = findViewById(R.id.rdHomme);
        rdFemme = findViewById(R.id.rdFemme);
        lblIMG = findViewById(R.id.lblMG);
        imgSmiley = findViewById(R.id.imgSmiley);
        btnCalc = findViewById(R.id.btnCalc);
        this.controle =Controle.getInstance(this);
       recupProfil();



        ecouteCalcul();
    }

    /**
     *
     * ecoute evenement sur bouton calcul
     */
    private void ecouteCalcul() {
       btnCalc.setOnClickListener(new Button.OnClickListener() {
           @Override
           public void onClick(View v) {
              // Toast.makeText(MainActivity.this,"test",Toast.LENGTH_SHORT).show();

               Integer poids = 0;
               Integer taille =0;
               Integer age =0;
               Integer sexe =0;

               //recuperation des datat  saisie
                try {

                    poids = Integer.parseInt(txtPoids.getText().toString());
                    taille = Integer.parseInt(txtTaille.getText().toString());
                    age = Integer.parseInt(txtAge.getText().toString());
                }
                catch (Exception e) {};

                sexe = rdHomme.isChecked() ? 1 : 0;

                if (poids ==0 || taille ==0 || age ==0) {

                    Toast.makeText(MainActivity.this,"Saisie incorrecte",Toast.LENGTH_SHORT).show();
                }
                else {
                    //saisie correcte

                    afficheResult(poids,taille,age, sexe);
                }


           }
       });


    }

    /**
     * affichage de l'img ; du message et de l'image
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    private void afficheResult(Integer poids, Integer taille, Integer age, Integer sexe) {

        //creation su profil et recuperation des information
        this.controle.creerProfil(poids, taille, age, sexe,this);

        float img = this.controle.getImg();
        String message = this.controle.getMessage();


        if (message == "normal") {
            imgSmiley.setImageResource(R.drawable.normal);
            lblIMG.setTextColor(Color.GREEN);
        }
        else if(message =="trop faible") {
            imgSmiley.setImageResource(R.drawable.maigre);
            lblIMG.setTextColor(Color.RED);


        }
        else {
            imgSmiley.setImageResource(R.drawable.graisse);
            lblIMG.setTextColor(Color.RED);


        }
        lblIMG.setText(String.format("%.01f",img) + " : IMG " + message);
    }

    /**
     * recuperation du profil si serialisé
     */

    private void recupProfil() {


        if (controle.getPoids() !=null) {
            txtPoids.setText(controle.getPoids());
            txtTaille.setText(controle.getTaille().toString());
            txtAge.setText(controle.getAge().toString());

            rdFemme.setChecked(true);
            if (controle.getSexe()==1) {

                rdHomme.setChecked(true);

            }
            //simule le click sur le boutton calcule
            ((Button)findViewById(R.id.btnCalc)).performClick();
        }


    }
}
