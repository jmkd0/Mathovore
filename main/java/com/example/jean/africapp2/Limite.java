package com.example.jean.africapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Limite extends AppCompatActivity {
    private EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limite);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setSubtitle("Afrik apps home");
        edit=(EditText)findViewById(R.id.edit);
        edit.append("f(x)=");
        Ecouteur();

    }
    public void Ecouteur(){

        TableLayout table=(TableLayout)findViewById(R.id.table);
        for(int i=0; i<table.getChildCount(); i++){
            View rowtab=table.getChildAt(i);
            if(rowtab instanceof TableRow){
                TableRow row=(TableRow)rowtab;
                for(int j=0; j<row.getChildCount(); j++){
                    View buttab=row.getChildAt(j);
                    if(buttab instanceof Button){
                        Button button=(Button)buttab;

                        button.setOnClickListener(new View.OnClickListener(){

                            public void onClick(View v){
                                String buttoncli=((Button)v).getText().toString();
                                if(buttoncli.equals("Asin")) buttoncli="Arcsin(";
                                if(buttoncli.equals("Asin")) buttoncli="Arcsin(";
                                if(buttoncli.equals("Acos")) buttoncli="Arccos(";
                                if(buttoncli.equals("Atan")) buttoncli="Arctan(";
                                if(buttoncli.equals("Sin")) buttoncli="Sin(";
                                if(buttoncli.equals("Cos")) buttoncli="Cos(";
                                if(buttoncli.equals("Tan")) buttoncli="Tan(";
                                if(buttoncli.equals("Ln")) buttoncli="Ln(";
                                if(buttoncli.equals("Exp")) buttoncli="Exp(";
                                Affichage(buttoncli);
                            }

                        });

                    }

                }
            }
        }

    }

    //Initialisation
    int k=1;
    private String chaine="0";

    String[] effacer=new String[50];
    public  void Affichage(String buttontext){

        //On initialise la premiere position à f(x)= pour pas l'effacer jamais du tableau
        effacer[0]="f(x)=";
        //On clique sur autres boutons autre que effacer et egalité
        if(!(buttontext.equalsIgnoreCase("⇦"))&&!(buttontext.equalsIgnoreCase("Reso"))){
            effacer[k]=buttontext;
            edit.append(buttontext);
            chaine=edit.getText().toString();
            k++;
        }
        //On clique sur le bouton effacer
        TextView text=new TextView(this);
        if(buttontext.equalsIgnoreCase("⇦")){
            text.setText("");
            if(k>1){
                k--;
                int l=chaine.length();
                int h=effacer[k].length();
                chaine=chaine.substring(0,l-h);
                edit.setText(chaine);
                if(k==1)	k=1;
                effacer[k]=null;
            }
        }

        // On clique sur le bouton egale
        if(buttontext.equalsIgnoreCase("Reso")&&chaine.length()>0){
            String str;
            str=chaine;
            Intent intent=new Intent(Limite.this, Limite1.class);
            intent.putExtra("limite",str);
            startActivity(intent);
        }
    }
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
