package com.example.jean.africapp2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;



public class Equation extends AppCompatActivity {
    private EditText edit;
    private ListView liste=null;
    boolean rep=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setSubtitle("Afrik apps home");
        liste=(ListView)findViewById(R.id.liste);
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
    private String chaine="f(x)=";

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
        final LinearLayout linear3 = (LinearLayout) findViewById(R.id.linear3);
        TextView text=new TextView(this);
        text.setTextColor(0xFFE9DBEA);
        text.setTextSize(24);
        text.setLines(2);
        if(buttontext.equalsIgnoreCase("⇦")){
           linear3.removeAllViews();
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
        //On clique sur AC
        if(buttontext.equalsIgnoreCase("AC")){
            linear3.removeAllViews();
            edit.setText("f(x)=");
            chaine="f(x)=";
            rep=true;
            k=1;
        }
        // On clique sur le bouton egale
        if(buttontext.equalsIgnoreCase("Reso")&&chaine.length()>0) {
            String str;
            str = chaine.replace("f(x)=", "");
            if (!str.equals("")) {
                int n = 0;
                double[] E = new double[200];
               for(double a=-100; a<=100; a+=0.01){
                   double y=eval(str, a);
                   if(y<0.0001&&y>-0.0001){
                       E[n]=Math.floor(a*100)/100; n++;
                   }
               }
                //Affichage


                if (rep == false) {
                    text.setText("Vous avez entré une fausse équation");
                    linear3.addView(text);
                    rep=true;
                } else {
                    if (n == 0) {
                        text.setText("Pas de solution trouvée dans les conditions de recherche");
                        linear3.addView(text);
                    } else {
                        String St = "S={";
                        for (int i = 0; i < n-1; i++) {
                            String r = String.format("%s", E[i]);
                            String rec = r.substring(r.length() - 2, r.length());
                            if (rec.equals(".0")) {
                                String st = r.substring(0, r.length() - 2);
                                St = St + " " + st + ", ";
                            } else St = St + " " + r + ", ";
                        }
                        String r = String.format("%s", E[n-1]);
                        String rec = r.substring(r.length() - 2, r.length());
                        if (rec.equals(".0")) {
                            String st = r.substring(0, r.length() - 2);
                            St = St + " " + st;
                        } else St = St + " " + r;
                        St = St + " }";
                        text.setText(St);
                        linear3.addView(text);

                    }
                }
            }else{
                Toast.makeText(Equation.this, "Veuillez à entrer votre équation", Toast.LENGTH_LONG).show();
            }
        }
    }

    //La fonction qui calcule l'image en prenant la foncrion str en argument avec le point à calculer d
    public  double eval(final String str, final double d) {
        final int l=str.length();
        class Parser {
            int pos = -1, c;
            void mangeChar() {
                c = (++pos < str.length()) ? str.charAt(pos) : -1;
            }
            void mangeSpace() {
                while (Character.isWhitespace(c)) {
                    mangeChar();
                }
            }
            double parse() {
                mangeChar();
                double v = parseExpression();
                if (c != -1) {
                    throw new RuntimeException("Unexpected: " + (char) c);
                }
                return v;
            }


            double parseExpression() {
                double v = parseTerm();
                for (;;) {
                    mangeSpace();
                    if (c == '+') {
                        mangeChar();
                        v += parseTerm();
                    } else if (c == '-') {
                        mangeChar();
                        v -= parseTerm();
                    } else {
                        return v;
                    }
                }
            }

            double parseTerm() {
                double v = parseFactor();
                for (;;) {
                    mangeSpace();
                    if (c == '/') {
                        mangeChar();
                        v /= parseFactor();
                    } else if (c == '*' || c == '(') {
                        if (c == '*') {
                            mangeChar();
                        }
                        v *= parseFactor();
                    } else {

                        return v;
                    }
                }
            }

            double parseFactor() {
                double v;
                boolean negate = false;
                mangeSpace();
                if (c == '(') {
                    mangeChar();
                    v = parseExpression();

                    if (c == ')') {

                        mangeChar();

                    }
                } else {
                    if (c == '+' || c == '-') {
                        negate = c == '-';
                        mangeChar();
                        mangeSpace();

                    }
                    if(!(c>='0'&&c<='9'||c=='.')){
                        v=1;
                        char q=str.charAt(0);
                        if(q=='²'||q=='³'||q=='!'||q=='^'||q==')'){mangeChar();  rep=false; int i=1;
                            while(i<l){mangeChar(); i++;}   }
                        char p=str.charAt(l-1);
                        if(p=='+'||p=='-'||p=='*'||p=='/'||p=='^'||p=='('||p=='√') rep=false;

                    }else{
                        StringBuilder sb= new StringBuilder();
                        while ((c >= '0' && c <= '9') || c == '.') {
                            sb.append((char) c);
                            mangeChar();
                        }
                        if (sb.length() == 0) {
                            throw new RuntimeException("Unexpected: " + (char) c);
                        }
                        String rec=sb.substring(0,1);
                        if(rec.equals(".")){ v=1; rep=false;
                        }else v=Double.parseDouble(sb.toString());

                    }
                }

                mangeSpace();
                if(c=='π'){
                    v=v*Math.PI;
                    mangeChar();
                    if(c=='π'){mangeChar(); v=v*Math.PI;
                        while(c=='π'){ mangeChar();v=v*Math.PI;
                        }}else{
                        if(c >= '0' && c <= '9'|| c == '.'){ mangeChar(); v=1.2;  rep=false;
                            while(c>='0'&&c<='9'||c=='.') mangeChar();
                        }}
                }
                if(c=='x'){
                    mangeChar();
                    if(c=='^'){
                        mangeChar();
                        v=v*Math.pow(d, parseFactor());
                    }else
                        v=v*d;
                }
                //Fonction sinus
                if(c=='S'){ mangeChar(); if(c=='i'){ mangeChar(); if(c=='n'){
                    mangeChar();
                    v=v*Math.sin(parseFactor());
                } }
                }
                //Fonction cosinus
                if(c=='C'){ mangeChar(); if(c=='o'){ mangeChar(); if(c=='s'){
                    mangeChar();
                    v=v*Math.cos(parseFactor());
                } }
                }
                //Fonction Tangente
                if(c=='T'){ mangeChar(); if(c=='a'){ mangeChar(); if(c=='n'){
                    mangeChar();
                    v=v*Math.tan(parseFactor());
                } }
                }
                //Fonction Arcsin Arccos et Arctan
                if(c=='A'){ mangeChar(); if(c=='r'){ mangeChar(); if(c=='c'){ mangeChar();
                    if(c=='s'){ mangeChar(); if(c=='i'){ mangeChar(); if(c=='n'){ mangeChar(); 	v=v*Math.asin(parseFactor());
                    }}}
                    if(c=='c'){ mangeChar(); if(c=='o'){ mangeChar(); if(c=='s'){ mangeChar(); 	v=v*Math.acos(parseFactor());
                    }}}
                    if(c=='t'){ mangeChar(); if(c=='a'){ mangeChar(); if(c=='n'){ mangeChar(); 	v=v*Math.atan(parseFactor());
                    }}}}}}


                //Fonction Logarithme
                //Fonction Logarithme
                if(c=='L'){ mangeChar(); if(c=='n'){
                    mangeChar();
                    double h=parseFactor();
                    v=v*Math.log(h);
                }}
                //Fonction Exponentielle
                if(c=='E'){ mangeChar(); if(c=='x'){ mangeChar(); if(c=='p'){
                    mangeChar();
                    v=v*Math.exp(parseFactor());
                }}}
                if (c == '^') { // exponentiation
                    mangeChar();
                    v = Math.pow(v, parseFactor());
                }
                if (negate) {
                    v = -v; // exponentiation has higher priority than unary minus: -3^2=-9
                }

                return v;
            }
        }
        return new Parser().parse();
    }
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
