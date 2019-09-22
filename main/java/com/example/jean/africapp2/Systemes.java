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
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Systemes extends AppCompatActivity {
    boolean erreur=false;
    String[] effacer=new String[50];
    double[][] M=new double[6][7];
    int[] I=new int[6];
    int k=0; int d=0;
    int ka=0;
    private String chaine="0";
    boolean rep=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_systemes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setSubtitle("Afrik apps home");
        final TextView equation=(TextView)findViewById(R.id.equation);
        Button retour=(Button)findViewById(R.id.retour);
        Button resoudre=(Button)findViewById(R.id.resoudre);
        Button ajouter=(Button)findViewById(R.id.ajouter);
        final LinearLayout linearsys2=(LinearLayout)findViewById(R.id.linearsys2);
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
                               // Affichage(buttoncli);
                                //On clique sur autres boutons autre que effacer et egalité
                                if(!(buttoncli.equalsIgnoreCase("⇦"))&&!(buttoncli.equalsIgnoreCase("DEL"))){
                                    effacer[ka]=buttoncli;

                                    equation.append(buttoncli);
                                    chaine=equation.getText().toString();
                                    ka++;
                                }
                                //On clique sur le bouton effacer
                                if(buttoncli.equalsIgnoreCase("⇦")){
                                    rep=true;
                                    if(ka>0){
                                        ka--;
                                        int l=chaine.length();
                                        int h=effacer[ka].length();
                                        chaine=chaine.substring(0,l-h);
                                       equation.setText(chaine);
                                        if(ka==0)	ka=0;
                                        effacer[ka]=null;
                                    }
                                }
                                //On clique sur AC
                                if(buttoncli.equalsIgnoreCase("DEL")){
                                    equation.setText("");
                                    chaine="0";
                                    rep=true;
                                    ka=0;
                                }
                            }

                        });

                    }

                }
            }
        }


        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                M[i][j]=0;
            }}
        for(int i=0; i<6; i++) I[i]=-1;
       final String[] Da=new String[6];
        for(int i=0; i<6; i++) Da[i]="togo";
        ajouter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String equa1=equation.getText().toString();
                equation.setText("");
                if(equa1.equals("")){
                    Toast.makeText(Systemes.this, "Veuillez saisir une autre equation. Merci", Toast.LENGTH_LONG).show();
                }else{
                    double[][] E=new double[2][7];
                    if(d<6){

                        E=Equation(equa1);
                        for(int i=0; i<6; i++){
                            if((int)E[1][i]!=I[i]&&(int)E[1][i]>I[i]){
                                I[i]=(int)E[1][i];
                            }
                        }
                        int h=-1;
                        for(int i=0; i<6; i++){
                            if(I[i]>h) h=I[i];
                        }
                        k=h+1;
                        //	Toast.makeText(MainActivity.this, String.format("%s",k), Toast.LENGTH_LONG).show();

                        if(erreur==true){
                            Toast.makeText(Systemes.this, "Veuillez saisir une autre equation celui ci contient d'erreur. Merci", Toast.LENGTH_LONG).show();
                            erreur=false;
                        }else{
                            for(int i=0; i<7; i++){
                                M[d][i]=E[0][i];
                            }
                             Da[d]=equa1;
                            TextView text=new TextView(Systemes.this);
                            text.setTextColor(0xFFE9DBEA);
                            text.setTextSize(18);
                            text.setText(equa1);
                            linearsys2.addView(text);
                        }
                        d++;
                    }
                }
            }});
        retour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                erreur=false; k=0; d=0;
                for(int i=0; i<6; i++){
                    for(int j=0; j<7; j++){
                        M[i][j]=0;
                    }}
                for(int i=0; i<6; i++) I[i]=-1;
                linearsys2.removeAllViews();

            }});
        resoudre.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                double[][] A=new double[6][7];
                char[] P=new char[6];
                P[0]='x'; P[1]='y'; P[2]='z'; P[3]='t'; P[4]='s'; P[5]='u';
                if(k==0){
                    Toast.makeText(Systemes.this, "Vous avez entré de mauvaises équations. Retournez et reprendre", Toast.LENGTH_LONG).show();
                }else{
                    A=Resolution(M, k);
                    String[] S=new String[k];
                    for(int n=0; n<6; n++){
                        int i=I[n];
                        if(i!=-1){
                            String p;
                            if(A[i][6]!=12340567){
                                p=P[i]+"=";
                                int cpt=0;
                                for(int j=0; j<6; j++){
                                    if(A[i][j]!=0){
                                        cpt++;
                                        if(A[i][j]>0){
                                            if(A[i][j]==1){
                                                p=p+"+"+P[j];
                                             }else {
                                                String r = String.format("%s", A[i][j]);
                                                String rec = r.substring(r.length() - 2, r.length());
                                                if (rec.equals(".0")) {
                                                    String st = r.substring(0, r.length() - 2);
                                                    p = p + "+" + st + P[j];
                                                } else p = p + "+" + r + P[j];
                                             }
                                        }else{
                                            if(A[i][j]==-1){
                                                p=p+P[j];
                                            }else {
                                                String r = String.format("%s", A[i][j]);
                                                String rec = r.substring(r.length() - 2, r.length());
                                                if (rec.equals(".0")) {
                                                    String st = r.substring(0, r.length() - 2);
                                                    p = p + st + P[j];
                                                } else p = p + r + P[j];
                                            }
                                        }
                                    }
                                }
                                if(cpt!=0){
                                    if(A[i][6]!=0){
                                        if(A[i][6]>0){
                                            if(A[i][6]==1){
                                                p=p+"+1";
                                            }else {
                                                String r = String.format("%s", A[i][6]);
                                                String rec = r.substring(r.length() - 2, r.length());
                                                if (rec.equals(".0")) {
                                                    String st = r.substring(0, r.length() - 2);
                                                    p = p + "+" + st;
                                                } else p = p + "+" + r;
                                            }
                                        }else{
                                            if(A[i][6]==-1){
                                                p=p+"-1";
                                            }else {
                                                String r = String.format("%s", A[i][6]);
                                                String rec = r.substring(r.length() - 2, r.length());
                                                if (rec.equals(".0")) {
                                                    String st = r.substring(0, r.length() - 2);
                                                    p = p + st;
                                                } else p = p+ r;
                                            }
                                        }
                                    }
                                }else{
                                    if(A[i][6]==0){
                                        p=p+"0";
                                    }else {
                                        String r = String.format("%s", A[i][6]);
                                        String rec = r.substring(r.length() - 2, r.length());
                                        if (rec.equals(".0")) {
                                            String st = r.substring(0, r.length() - 2);
                                            p = p + st;
                                        } else p = p+ r;
                                    }
                                }
                            }else{
                                p=P[i]+" ∈R";
                            }

                            String q=p.substring(2,3);
                            if(q.equals("+")){
                                String r=p.substring(3,p.length()), j=p.substring(0,2);
                                p=j+r;
                            }
                            S[i]=p;
                        }
                    }
                    Intent intent = new Intent(Systemes.this, Systeme1.class);
                    intent.putExtra("equationsindex", d);
                    intent.putExtra("solutionsindex", k);
                    for(int i=0; i<d; i++){
                        intent.putExtra("1"+String.format("%s",i), Da[i]);
                    }
                    for(int i=0; i<k; i++){
                        intent.putExtra("2"+String.format("%s",i), S[i]);
                    }
                    startActivity(intent);
                }
            }});

    }
    double[][] D=new double[2][7];
    public double[][] Equation( String equa1){
        char[] A=new char[7];
        for(int i=0; i<6; i++) D[1][i]=-1; D[1][6]=0;
        A[0]='x'; A[1]='y'; A[2]='z'; A[3]='t'; A[4]='s'; A[5]='u'; A[6]='v';
        if(equa1.indexOf('=')==-1){
            erreur=true;
        }else{
            equa1=equa1+"v+";
            if(equa1.charAt(0)!='-'&&equa1.charAt(0)!='+') equa1="+"+equa1;
            for(int i=0; i<7;  i++){
                int a=equa1.indexOf(A[i]);
                if(a==-1){
                    D[0][i]=0;
                }else{
                    char d=equa1.charAt(a+1);
                    if(!(d=='-'||d=='+'||d=='=')){ erreur=true;
                    }else{
                        D[1][i]=i;
                        StringBuilder sb=new StringBuilder();
                        char c=equa1.charAt(a-1);
                        while(a>=0&&((c>='0'&&c<='9')||c=='.'||c=='/')){
                            sb.append((char)c); a--; c=equa1.charAt(a-1);
                        }
                        if(sb.length()==0){
                            D[0][i]=1;
                        }else{
                            StringBuilder sb1=new StringBuilder();
                            for(int k=sb.length()-1; k>=0; k--){
                                sb1.append(sb.charAt(k));
                            }
                            int m=sb1.indexOf("/");
                            if(m!=-1){
                                if(m!=sb1.length()-1&&m!=0){
                                    String p=sb1.substring(0,m), q=sb1.substring(m+1, sb1.length());
                                    if(p.length()>0&&q.length()>0){
                                        D[0][i]=Double.parseDouble(p.toString())/Double.parseDouble(q.toString());
                                    }else erreur=true;
                                }else erreur=true;
                            }else  D[0][i]=Double.parseDouble(sb1.toString());
                        }
                        if(c=='-') D[0][i]=-D[0][i];
                    }
                }
            }}
        return D;
    }
    public  double[][] Resolution(double[][] T, int a){
        for(int k=a-2; k>=0; k--){
            if(T[k+1][k+1]==0){
                int p=k; double Rec;
                while((p>=0)&&T[p][k+1]==0) p--;
                if(p>=0){
                    for(int i=6; i>=0; i--){
                        Rec=T[p][i]; T[p][i]=T[k+1][i];	T[k+1][i]=Rec;
                    }
                }
            }
            for(int i=k; i>=0; i--){
                if(T[k+1][k+1]!=0){
                    double d=T[i][k+1]/T[k+1][k+1];
                    for(int j=6; j>=0; j--){
                        T[i][j]-=T[k+1][j]*d;
                    }
                }
            }
        }
        double[][] A=new double[6][7];
        for(int i=0; i<a; i++){
            for(int j=0; j<i; j++){
                A[i][j]=-T[i][j]/T[i][i];
            }
            for(int j=i+1; j<6; j++){
                A[i][j]=0;
            }
            A[i][6]=T[i][6]/T[i][i];
            A[i][i]=0;
        }

        for(int i=a-1; i>=0; i--){
            if(Double.isInfinite(A[i][6])||Double.isNaN(A[i][6])){
                for(int j=0; j<i; j++){
                    A[i][j]=0;
                }
                A[i][6]=12340567;
            }  else{
                for(int j=i+1; j<a; j++){
                    double d=A[j][i];
                    for(int k=0; k<i; k++){
                        A[j][k]+=d*A[i][k];
                    }
                    A[j][i]=0;
                    A[j][6]+=d*A[i][6];
                }
            }
        }
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                A[i][j]=(double)(Math.floor(A[i][j]*1000))/1000;
            }}

        return A;
    }
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

}
