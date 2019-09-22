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
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Limite1 extends AppCompatActivity {
 private EditText edit;
    private String fonc;
    boolean rep=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limite1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setSubtitle("Afrik apps home");
         edit=(EditText)findViewById(R.id.edit);
        TextView textfonc=(TextView)findViewById(R.id.textfonc);
         Bundle bundle=this.getIntent().getExtras();
        String str=bundle.getString("limite");
        fonc=str.replace("f(x)=", "");
        textfonc.setText(str);
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
                                Affichage(buttoncli);
                            }

                        });

                    }

                }
            }
        }

    }

    //Initialisation
    int k=0;
    private String chaine="0";

    String[] effacer=new String[50];
    public  void Affichage(String buttontext){

        //On initialise la premiere position à f(x)= pour pas l'effacer jamais du tableau

        //On clique sur autres boutons autre que effacer et egalité
        if(!(buttontext.equalsIgnoreCase("⇦"))&&!(buttontext.equalsIgnoreCase("Calculer"))){
            effacer[k]=buttontext;
            edit.append(buttontext);
            chaine=edit.getText().toString();
            k++;
        }
        //On clique sur le bouton effacer
        TextView textlim11=(TextView)findViewById(R.id.textlim11);
        TextView textx11=(TextView)findViewById(R.id.textx11);
        TextView textsi11=(TextView)findViewById(R.id.textsi11);
        TextView textlim22=(TextView)findViewById(R.id.textlim22);
        TextView textx22=(TextView)findViewById(R.id.textx22);
        TextView textsi22=(TextView)findViewById(R.id.textsi22);
        if(buttontext.equalsIgnoreCase("⇦")){
            textlim11.setText("");
            textlim22.setText("");
            textx11.setText("");
            textx22.setText("");
            textsi11.setText("");
            textsi22.setText("");
            if(k>0){
                k--;
                int l=chaine.length();
                int h=effacer[k].length();
                chaine=chaine.substring(0,l-h);
                edit.setText(chaine);
                effacer[k]=null;
            }
        }

        // On clique sur le bouton egale
        if(buttontext.equalsIgnoreCase("Calculer")&&chaine.length()>0){
            if(chaine.equals("")){
                Toast.makeText(Limite1.this, "Veuillez entrer la valeur de x. Merci", Toast.LENGTH_LONG).show();
            }else{
                if((chaine.length()>2&&chaine.indexOf('∞')!=-1)||chaine.equals(".")||chaine.equals("-")||chaine.equals("-.")||(chaine.indexOf('-')>0)){
                    Toast.makeText(Limite1.this, "Vous avez entrer une mauvaise valeur.", Toast.LENGTH_LONG).show();
                }else{
                    double  a; double b=Math.pow(10,100);
                    if(chaine.equals("+∞")){
                        a=b;
                    }else{
                        if(chaine.equals("-∞")){
                            a=-b;
                        }else a=Double.parseDouble(chaine.toString());
                    }
                    if((a<=100&&a>=-100)||a==-b||a==b) {
                        double lim = eval(fonc, a);
                        if (rep == false) {
                            Toast.makeText(Limite1.this, "Vous avez entrés une mauvaise fonction retournez et reprendre.", Toast.LENGTH_LONG).show();
                            rep = true;
                        } else {
                            double dou = (double) Math.round(lim * 100) / 100;
                            String limp1 = String.format("%s", dou);
                            String r = limp1;
                            String rec = r.substring(r.length() - 2, r.length());
                            if (rec.equals(".0")) {
                                String st = r.substring(0, r.length() - 2);
                                limp1 = st;
                            }
                            String sl = "Lim f(x)= ", sx = "x↦";
                            if ((Double.isInfinite(lim) || Double.isNaN(lim) || lim < -100 || lim > 100) && (a < 101 && a > -101)) {
                                double pr = Math.pow(10, -10);
                                double lim1 = eval(fonc, a - pr);
                                double lim2 = eval(fonc, a + pr);
                                double dou1 = (double) (Math.round(lim1 * 100)) / 100;
                                double dou2 = (double) Math.round(lim2 * 100) / 100;
                                String lim11 = String.format("%s", dou1);
                                String r1 = lim11;
                                String rec1 = r1.substring(r1.length() - 2, r1.length());
                                if (rec1.equals(".0")) {
                                    String st1 = r1.substring(0, r1.length() - 2);
                                    lim11 = st1;
                                }
                                if (lim11.equals("-Infinity") || lim1 < -100) {
                                    textlim11.setText(sl + "-∞");
                                    textx11.setText(sx + chaine);
                                    textsi11.setText("   ➘");
                                } else {
                                    if (lim11.equals("Infinity") || lim1 > 100) {
                                        textlim11.setText(sl + "+∞");
                                        textx11.setText(sx + chaine);
                                        textsi11.setText("   ➘");
                                    } else {
                                        if (Double.isNaN(lim1)) {
                                            textlim11.setText(sl + "Indef");
                                            textx11.setText(sx + chaine);
                                            textsi11.setText("   ➘");
                                        } else {
                                            textlim11.setText(sl + lim11);
                                            textx11.setText(sx + chaine);
                                            textsi11.setText("   ➘");
                                        }
                                    }
                                }
                                String lim22 = String.format("%s", dou2);
                                String r2 = lim22;
                                String rec2 = r2.substring(r2.length() - 2, r2.length());
                                if (rec2.equals(".0")) {
                                    String st2 = r2.substring(0, r2.length() - 2);
                                    lim22 = st2;
                                }
                                if (lim22.equals("Infinity") || lim2 > 100) {
                                    textlim22.setText(sl + "+∞");
                                    textx22.setText(sx + chaine);
                                    textsi22.setText("   ➚");
                                } else {
                                    if (lim22.equals("-Infinity") || lim2 < -100) {
                                        textlim22.setText(sl + "-∞");
                                        textx22.setText(sx + chaine);
                                        textsi22.setText("   ➚");
                                    } else {
                                        if (Double.isNaN(lim2)) {
                                            textlim22.setText(sl + "Indef");
                                            textx22.setText(sx + chaine);
                                            textsi22.setText("   ➚");
                                        } else {
                                            textlim22.setText(sl + lim22);
                                            textx22.setText(sx + chaine);
                                            textsi22.setText("   ➚");
                                        }
                                    }
                                }
                            }
                            if (a < -100 || a > 100) {
                                if (limp1.equals("Infinity") || lim > 100) {
                                    textlim11.setText(sl + "+∞");
                                    textx11.setText(sx + chaine);
                                } else {
                                    if (limp1.equals("-Infinity") || lim < -100) {
                                        textlim11.setText(sl + "-∞");
                                        textx11.setText(sx + chaine);
                                    } else {
                                        textlim11.setText(sl + limp1);
                                        textx11.setText(sx + chaine);
                                    }
                                }
                            }
                            if ((a <= 100 && a >= -100) && (lim <= 100 && lim >= -100)) {
                                textlim11.setText(sl + limp1);
                                textx11.setText(sx + chaine);
                            }
                        }
                        }else{
                            Toast.makeText(Limite1.this, "La valeur entrée est trop grande", Toast.LENGTH_LONG).show();
                        }

                }
          }

        }
    }
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
