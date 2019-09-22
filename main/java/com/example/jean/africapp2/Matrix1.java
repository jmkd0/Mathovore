package com.example.jean.africapp2;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static android.R.attr.typeface;
import static android.R.attr.width;
import static android.R.drawable.ic_input_add;
import static com.example.jean.africapp2.R.attr.height;
import static com.example.jean.africapp2.R.id.lineartext;
import static com.example.jean.africapp2.R.id.textView;

public class Matrix1 extends AppCompatActivity {
    EditText[][] A=new EditText[10][10];
    double[][] A1=new double[10][10];
    String[][] A11=new String[10][10];
    EditText[][] B=new EditText[10][10];
    double[][] B1=new double[10][10];
    String[][] B11=new String[10][10];
    double det=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setSubtitle("Afrik apps home");
        LinearLayout line=(LinearLayout)findViewById(R.id.line);
        line.removeAllViews();
        final LinearLayout linear=(LinearLayout)findViewById(R.id.linear);
        final LinearLayout linear2=(LinearLayout)findViewById(R.id.linear2);
        final LinearLayout linear31=(LinearLayout)findViewById(R.id.linear31);
        final LinearLayout linear32=(LinearLayout)findViewById(R.id.linear32);
       // final LinearLayout linear311=(LinearLayout)findViewById(R.id.linear311);
        final LinearLayout linearegale=(LinearLayout)findViewById(R.id.linearegale);
        final LinearLayout lineartext=(LinearLayout)findViewById(R.id.lineartext);
        final LinearLayout lineargrid=(LinearLayout)findViewById(R.id.lineargrid);
        final LinearLayout linear5=(LinearLayout)findViewById(R.id.linear5);
        final Bundle position=this.getIntent().getExtras();

        final TextView textview=new TextView(this);
        final TextView textview1=new TextView(this);
        final TextView textview2=new TextView(this);
        final TextView textsom=new TextView(this);
        final TextView textpro=new TextView(this);
        final TextView textsigne=new TextView(this);
        final TextView textegale=new TextView(this);
        final EditText edit1=new EditText(this);
        final EditText edit2=new EditText(this);
        final Button button=new Button(this);

        textsom.setText("Voici la somme des matrices voulues");
        textsom.setTextColor(0xFF76DDDE);
        textpro.setText("Voici le produit des matrices voulues");
        textpro.setTextColor(0xFF76DDDE);
        textview.setText("Veuillez entrer le nombre de ligne et de colonne positifs et inférieurs à 7");
        textview.setTextSize(18);
        textview.setTextColor(0xFFFFFFFF);
        textview.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        textview1.setText("Veuillez remplir tous les éléments de votre matrice et cliquez sur ENREGISTRER. Attention: la procedure est irréversible apres avoir validé l'étape");
        textview.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        textview1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        textview1.setTextColor(0xFFB4CAD1);
        textview2.setText("Veuillez remplir tous les éléments de votre seconde matrice et cliquez sur CALCULER.");
        textview2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        textview2.setTextColor(0xFFB4CAD1);
        linear.addView(textview);

        textsigne.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        textsigne.setTextColor(0xFFFEFEFE);
        textsigne.setTextSize(40);
        textsigne.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        textegale.setTextColor(0xFF94DCD0);
        textegale.setTextSize(40);
        textegale.setPadding(20,0,30,0);
        textegale.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        final LinearLayout linear1=(LinearLayout)findViewById(R.id.linear1);
        edit1.setHint("Ligne");
        edit2.setHint("Colon");
        edit1.setHintTextColor(0xFFF4F4F4);
        edit2.setHintTextColor(0xFFF4F4F4);//blanc
        edit1.setBackgroundColor(0xFF354F66);
        edit2.setBackgroundColor(0xFF354F66);
        edit1.setInputType(InputType.TYPE_CLASS_NUMBER);
        edit2.setInputType(InputType.TYPE_CLASS_NUMBER);
        button.setText("Valider");
        button.setTextColor(0xFF9A1FB8);
        button.setAllCaps(false);
        edit1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        edit2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        button.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        linear1.addView(edit1);
        linear1.addView(edit2);
        linear1.addView(button);

        final Button annuler=new Button(this);
        final Button button1=new Button(this);
        final Button somvalider=new Button(this);
        final Button provalider=new Button(this);
        final Button annuler1=new Button(this);
        final Button annuler2=new Button(this);
        final TextView valeurdet=new TextView(this);
        annuler2.setText("Retour");
        annuler2.setTextColor(0xFF9A1FB8);
        annuler2.setAllCaps(false);
        annuler1.setText("Retour");
        annuler1.setTextColor(0xFF9A1FB8);
        annuler1.setAllCaps(false);
        annuler.setText("Retour");
        annuler.setTextColor(0xFF9A1FB8);
        annuler.setAllCaps(false);
        button1.setText("Enregistrer");
        button1.setTextColor(0xFF9A1FB8);
        button1.setTranslationX(75);
        button1.setAllCaps(false);
        somvalider.setText("Calculer somme");
        somvalider.setTextColor(0xFF9A1FB8);
        somvalider.setAllCaps(false);
        somvalider.setTranslationX(75);
        provalider.setText("Calculer produit");
        provalider.setTextColor(0xFF9A1FB8);
        provalider.setAllCaps(false);
        provalider.setTranslationX(75);
        annuler.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        button1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        valeurdet.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                final String rows=edit1.getText().toString();
                final String cols=edit2.getText().toString();
                final int row, col;
                if(rows.equals("")||cols.equals("")){
                    Toast.makeText(Matrix1.this,"Veillez entrer la taille de la matrice d'abord",Toast.LENGTH_LONG).show();
                }else{

                    if(Integer.parseInt(rows)>0&&Integer.parseInt(cols)>0&&Integer.parseInt(rows)<7&&Integer.parseInt(cols)<7){
                        linear.removeAllViews();
                        linear1.removeAllViews();
                        row=Integer.parseInt(rows);
                        col=Integer.parseInt(cols);
                        linear2.addView(textview1);
                        A=matrixA(row, col);
                        final LinearLayout linear4=(LinearLayout)findViewById(R.id.linear4);
                        linear4.addView(annuler);
                        linear4.addView(button1);
                        annuler.setOnClickListener(new View.OnClickListener(){
                            @Override
                            public void onClick(View view){
                                linear2.removeAllViews();
                                linear31.removeAllViews();
                                linear4.removeAllViews();
                                linear5.removeAllViews();
                                button1.setEnabled(true);
                                det=1;
                                linear.addView(textview);
                                linear1.addView(edit1);
                                linear1.addView(edit2);
                                linear1.addView(button);

                            }});
                        button1.setOnClickListener(new View.OnClickListener(){
                            @Override
                            public void onClick(View view){
                                for(int i=0; i<row; i++){
                                    for(int j=0; j<col; j++){
                                        String s=A[i][j].getText().toString();
                                        if(!s.equals("")){
                                            A1[i][j]=Double.parseDouble(s);
                                            A11[i][j]=String.format("%s",A1[i][j]);
                                            String t=A11[i][j];
                                            String rec=t.substring(t.length()-2,t.length());
                                            if(rec.equals(".0")){
                                                String st=t.substring(0,t.length()-2);
                                                A11[i][j]=st;
                                            } else A11[i][j]=t;
                                        }else{
                                            A1[i][j]=0; A11[i][j]="0";}
                                    }
                                }

                                int   pos=position.getInt("position");


                                if(pos==1){
                                    linear2.removeAllViews();
                                    linear31.removeAllViews();
                                    linear4.removeAllViews();
                                    linear2.addView(textview2);
                                    B=matrixB(row, col);
                                    linear4.addView(annuler1);
                                    linear4.addView(somvalider);
                                    annuler1.setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View view){
                                            linear2.removeAllViews();
                                            linear32.removeAllViews();
                                            linear4.removeAllViews();
                                            linear2.addView(textview1);
                                            A=matrixA(row, col);
                                            linear4.addView(annuler);
                                            linear4.addView(button1);
                                            for (int i = 0; i < row; i++) {
                                                for (int j = 0; j < col; j++) {
                                                    A1[i][j]=0;
                                                }}
                                        }});
                                    final double[][] S=new double[row][col];
                                    somvalider.setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View view){
                                            for(int i=0; i<row; i++){
                                                for(int j=0; j<col; j++){
                                                    String s=B[i][j].getText().toString();
                                                    if(!s.equals("")){
                                                        B1[i][j]=Double.parseDouble(s);
                                                        B11[i][j]=String.format("%s",B1[i][j]);
                                                        String t=B11[i][j];
                                                        String rec=t.substring(t.length()-2,t.length());
                                                        if(rec.equals(".0")){
                                                            String st=t.substring(0,t.length()-2);
                                                            B11[i][j]=st;
                                                        } else B11[i][j]=t;
                                                    }else{
                                                        B1[i][j]=0; B11[i][j]="0";}
                                                }
                                            }
                                            linear2.removeAllViews();
                                            linear32.removeAllViews();
                                            linear4.removeAllViews();
                                            String[][] S1=new String[row][col];
                                            int k=0;
                                            for (int i = 0; i < row; i++) {
                                                for (int j = 0; j < col; j++) {
                                                    S[i][j]=A1[i][j]+B1[i][j];
                                                    S1[i][j]=String.format("%s",S[i][j]);
                                                    String s=S1[i][j];
                                                    String rec=s.substring(s.length()-2,s.length());
                                                    if(rec.equals(".0")){
                                                        String st=s.substring(0,s.length()-2);
                                                        S1[i][j]=st;
                                                    } else S1[i][j]=s;
                                                }}
                                            linear2.addView(textsom);
                                            affiche1(A11,row,col);
                                            textsigne.setText("+");
                                            lineartext.addView(textsigne);
                                            affiche2(B11,row,col);
                                            textegale.setText("=");
                                            linearegale.addView(textegale);
                                           affiche(S1,row,col);
                                            linear4.addView(annuler2);
                                            annuler2.setOnClickListener(new View.OnClickListener(){
                                                @Override
                                                public void onClick(View view){
                                                    linear2.removeAllViews();
                                                    linear32.removeAllViews();
                                                    linear31.removeAllViews();
                                                    lineartext.removeAllViews();
                                                    linearegale.removeAllViews();
                                                    lineargrid.removeAllViews();
                                                    linear4.removeAllViews();
                                                    linear2.addView(textview2);
                                                    B=matrixB(row, col);
                                                    linear4.addView(annuler1);
                                                    linear4.addView(somvalider);
                                                    for (int i = 0; i < row; i++) {
                                                        for (int j = 0; j < col; j++) {
                                                            B1[i][j]=0;
                                                        }}

                                                }});
                                        }
                                    });
                                }
                                if(pos==2){
                                    linear2.removeAllViews();
                                    linear31.removeAllViews();
                                    linear4.removeAllViews();
                                    linear2.addView(textview2);
                                    B=matrixB(col, row);
                                    linear4.addView(annuler1);
                                    linear4.addView(provalider);
                                    annuler1.setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View view){
                                            linear2.removeAllViews();
                                            linear32.removeAllViews();
                                            linear4.removeAllViews();
                                            linear2.addView(textview1);
                                            A=matrixA(row, col);
                                            linear4.addView(annuler);
                                            linear4.addView(button1);
                                            for (int i = 0; i < row; i++) {
                                                for (int j = 0; j < col; j++) {
                                                    A1[i][j]=0;
                                                }}
                                        }});
                                    final double[][] S=new double[row][row];
                                    provalider.setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View view){
                                            for(int i=0; i<col; i++){
                                                for(int j=0; j<row; j++){
                                                    String s=B[i][j].getText().toString();
                                                    if(!s.equals("")){
                                                        B1[i][j]=Double.parseDouble(s);
                                                        B11[i][j]=String.format("%s",B1[i][j]);
                                                        String t=B11[i][j];
                                                        String rec=t.substring(t.length()-2,t.length());
                                                        if(rec.equals(".0")){
                                                            String st=t.substring(0,t.length()-2);
                                                            B11[i][j]=st;
                                                        } else B11[i][j]=t;
                                                    }else{
                                                        B1[i][j]=0; B11[i][j]="0";}
                                                }
                                            }
                                            linear2.removeAllViews();
                                            linear32.removeAllViews();
                                            linear4.removeAllViews();
                                           String[][] S1=new String[row][row];
                                            for (int i = 0; i < row; i++) {
                                                for (int j = 0; j < row; j++) {
                                                    double d=0;
                                                    for(int a=0; a<col; a++){
                                                        d+=A1[i][a]*B1[a][j];
                                                    }
                                                    S[i][j]=d;
                                                    S1[i][j]=String.format("%s",S[i][j]);
                                                    String s=S1[i][j];
                                                    String rec=s.substring(s.length()-2,s.length());
                                                    if(rec.equals(".0")){
                                                        String st=s.substring(0,s.length()-2);
                                                        S1[i][j]=st;
                                                    } else S1[i][j]=s;
                                                }}
                                            linear2.addView(textpro);
                                            affiche1(A11,row,col);
                                            textsigne.setText("X");
                                            lineartext.addView(textsigne);
                                            affiche2(B11,col,row);
                                            textegale.setText("=");
                                            linearegale.addView(textegale);
                                            affiche(S1,row,row);
                                            linear4.addView(annuler2);
                                            annuler2.setOnClickListener(new View.OnClickListener(){
                                                @Override
                                                public void onClick(View view){
                                                    linear2.removeAllViews();
                                                    linear32.removeAllViews();
                                                    linear31.removeAllViews();
                                                    lineartext.removeAllViews();
                                                    linearegale.removeAllViews();
                                                    lineargrid.removeAllViews();
                                                    linear4.removeAllViews();
                                                    linear2.addView(textview2);
                                                    B=matrixB(col,row);
                                                    linear4.addView(annuler1);
                                                    linear4.addView(provalider);
                                                    for (int i = 0; i < col; i++) {
                                                        for (int j = 0; j < row; j++) {
                                                            B1[i][j]=0;
                                                        }}

                                                }});
                                        }
                                    });
                                }
                                if(pos==3){
                                    if(row==col){

                                        String s=String.format("%s",detA(A1,row,0));
                                        String rec=s.substring(s.length()-2,s.length());
                                        if(rec.equals(".0")){
                                            String st=s.substring(0,s.length()-2);
                                            valeurdet.setText("Le déterminant de A est Det(A)= "+st);
                                        } else valeurdet.setText("Le déterminant de A est Det(A)= "+s);

                                        valeurdet.setTextColor(0xFFEBEFF2);
                                        valeurdet.setTextSize(16);
                                        valeurdet.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));
                                        valeurdet.setBackgroundColor(0xFF1F102F);
                                        linear5.addView(valeurdet);
                                        button1.setEnabled(false);
                                    }else{
                                        Toast.makeText(Matrix1.this, "Veuillez retourner pour choisir une taille carrée nxn. Merci", Toast.LENGTH_LONG).show();
                                    }
                                }
                                if(pos==4){
                                    if(row==col){
                                        valeurdet.setText("Le polynome Caractéristique de votre matrice est: P(X)=");
                                        valeurdet.setTextColor(0xFF76DDDE);
                                        valeurdet.setTextSize(16);
                                        valeurdet.setLines(3);
                                        valeurdet.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));
                                        valeurdet.setBackgroundColor(0xFF1F102F);
                                        if(row%2!=0) valeurdet.append("-");
                                        int cpt=0;
                                        for(double d=-50; d<=50; d+=0.1){
                                            double[][] T=new double[row][row];
                                            for(int i=0; i<row; i++){
                                                for(int j=0; j<row; j++){
                                                    T[i][j]=A1[i][j];
                                                }}
                                            BigDecimal k=new BigDecimal(d).setScale(1, RoundingMode.HALF_UP);
                                            double  c=k.doubleValue();
                                            double  s=detA(T, T.length, c);
                                            if(s==0){
                                                cpt++;
                                                double e=0.0001,  y=0; int n=1;
                                                while(y==0){
                                                    for(int i=0; i<=n; i++){
                                                        y+=Math.pow(-1,n-i)*Comb(n,i)*detA(T,T.length,c+i*e);
                                                    }
                                                    y*=1/Math.pow(e,n);
                                                    if((double)Math.floor(y*10/10)==0) n++;
                                                }
                                                if(c<0){
                                                    String r=String.format("%s",-c);
                                                    String rec=r.substring(r.length()-2,r.length());
                                                    if(rec.equals(".0")){
                                                        String st=r.substring(0,r.length()-2);
                                                        if(n==1) {
                                                            valeurdet.append("(X+" + st + ")");
                                                        }else valeurdet.append("(X+" + st + ")^"+n);
                                                    } else{
                                                        if(n==1){
                                                            valeurdet.append("(X+"+r+")");
                                                        }else valeurdet.append("(X+"+r+")^"+n);
                                                    }

                                                }
                                                if(c>0){
                                                    String r=String.format("%s",c);
                                                    String rec=r.substring(r.length()-2,r.length());
                                                    if(rec.equals(".0")){
                                                        String st=r.substring(0,r.length()-2);
                                                        if(n==1) {
                                                            valeurdet.append("(X-" + st + ")");
                                                        }else  valeurdet.append("(X-" + st + ")^"+n);
                                                    } else{
                                                        if(n==1){
                                                            valeurdet.append("(X-"+r+")");
                                                        }else valeurdet.append("(X-"+r+")^"+n);
                                                    }
                                                }
                                                if(c==0){
                                                    if(n==1){
                                                        valeurdet.append("X");
                                                    }else valeurdet.append("X^"+n);
                                                }
                                            }
                                        }
                                        if(cpt==0){
                                            valeurdet.setText("Votre matrice n'admet pas de polynome réel dans [-50,50]. Veuillez entrer une autre...");
                                        }
                                        linear5.addView(valeurdet);
                                        button1.setEnabled(false);
                                    }else{
                                        Toast.makeText(Matrix1.this, "Veuillez retourner pour choisir une taille carrée nxn. Merci", Toast.LENGTH_LONG).show();
                                    }
                                }
                                if(pos==5){
                                    if(row==col){
                                        double[][] B=new double[row][row];
                                        for(int i=0; i<row; i++){
                                            for(int j=0; j<row; j++){
                                                B[i][j]=A1[i][j];
                                            }}
                                        double[][] Inv=new double[row][row];
                                        double d=detA(B,row,0);
                                        if(d!=0){
                                            for(int i=0; i<row; i++){
                                                for(int j=0; j<row; j++){
                                                    double[][] V1=new double[row-1][row-1];
                                                    for(int k=0; k<i; k++){
                                                        for(int l=0; l<j; l++){
                                                            V1[k][l]=A1[k][l];
                                                        }
                                                        for(int l=j+1; l<row; l++){
                                                            V1[k][l-1]=A1[k][l];
                                                        }
                                                    }
                                                    for(int k=i+1; k<row; k++){
                                                        for(int l=0; l<j; l++){
                                                            V1[k-1][l]=A1[k][l];
                                                        }
                                                        for(int l=j+1; l<row; l++){
                                                            V1[k-1][l-1]=A1[k][l];
                                                        }
                                                    }

                                                    Inv[j][i]=Math.pow(-1,i+j)*detA(V1,row-1,0)/d;

                                                } }
                                        }
                                        TextView textinverse=new TextView(Matrix1.this);
                                        textinverse.setText("Voici l'inverse de la matrice que vous désirez..");
                                        textinverse.setTextColor(0xFFEBEFF2);
                                        linear2.removeAllViews();
                                        linear31.removeAllViews();
                                        linear4.removeAllViews();
                                        linear2.addView(textinverse);
                                        String[][] S1=new String[row][row];
                                        int k=0;
                                        for (int i = 0; i < row; i++) {
                                            for (int j = 0; j < row; j++) {
                                                BigDecimal big=new BigDecimal(Inv[i][j]).setScale(3,RoundingMode.HALF_UP);
                                                S1[i][j]=String.format("%s",big);
                                                k++;
                                            }
                                        }
                                        affiche2(A11,row,row);
                                        textegale.setText("a pour inverse");
                                        textegale.setTextSize(22);
                                        linearegale.addView(textegale);
                                        affiche(S1,row,row);
                                        linear4.addView(annuler1);
                                        annuler1.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View view){
                                                linear2.removeAllViews();
                                                linear32.removeAllViews();
                                                linearegale.removeAllViews();
                                                lineargrid.removeAllViews();
                                                linear4.removeAllViews();
                                                linear2.addView(textview1);
                                                A=matrixA(row, col);
                                                linear4.addView(annuler);
                                                linear4.addView(button1);
                                                for (int i = 0; i < row; i++) {
                                                    for (int j = 0; j < col; j++) {
                                                        A1[i][j]=0;
                                                    }}
                                            }});
                                    }else{
                                        Toast.makeText(Matrix1.this, "Veuillez retourner pour choisir une taille carrée nxn. Merci", Toast.LENGTH_LONG).show();
                                    }
                                }
                                if(pos==6){}
                            }});

                    }else{
                        Toast.makeText(Matrix1.this, "Veuillez entrer les entiers positifs et inférieur à 7. Merci", Toast.LENGTH_LONG).show();
                    }
                }


            }
        });

    }
    public EditText[][] matrixA(int row, int col){
        final EditText[][] editTexts = new EditText[row][col];
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        gridLayout.setRowCount(row);
        gridLayout.setColumnCount(col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                editTexts[i][j] = new EditText(this);
                setPos(editTexts[i][j], i, j);
                gridLayout.addView(editTexts[i][j]);
            }
        }
        LinearLayout linear31=(LinearLayout)findViewById(R.id.linear31);
        linear31.addView(gridLayout);
        return editTexts;
    }

    public EditText[][] matrixB(int row, int col){
        final EditText[][] editTexts = new EditText[row][col];
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        gridLayout.setRowCount(row);
        gridLayout.setColumnCount(col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                editTexts[i][j] = new EditText(this);
                setPos(editTexts[i][j], i, j);
                gridLayout.addView(editTexts[i][j]);
            }
        }
        LinearLayout linear32=(LinearLayout)findViewById(R.id.linear32);
        linear32.addView(gridLayout);
        return editTexts;
    }
    private void affiche1(String[][] S, int row, int col) {
        GridLayout gridaffiche = new GridLayout(this);
        gridaffiche.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        TextView[][] texts = new TextView[row][col];
        gridaffiche.setRowCount(row);
        gridaffiche.setColumnCount(col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                texts[i][j] = new TextView(this);
                texts[i][j].setText(S[i][j]);
                setPosaffiche(texts[i][j], i, j);
                gridaffiche.addView(texts[i][j]);
            }
        }
        LinearLayout linear31 = (LinearLayout) findViewById(R.id.linear31);
        linear31.addView(gridaffiche);
    }
    private void affiche2(String[][] S, int row, int col) {
        GridLayout gridaffiche = new GridLayout(this);
        gridaffiche.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        TextView[][] texts = new TextView[row][col];
        gridaffiche.setRowCount(row);
        gridaffiche.setColumnCount(col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                texts[i][j] = new TextView(this);
                texts[i][j].setText(S[i][j]);
                setPosaffiche(texts[i][j], i, j);
                gridaffiche.addView(texts[i][j]);
            }
        }
        LinearLayout linear32 = (LinearLayout) findViewById(R.id.linear32);
        linear32.addView(gridaffiche);
    }
    private void affiche(String[][] S, int row, int col){
        GridLayout gridaffiche=new GridLayout(this);
        gridaffiche.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        TextView[][] texts=new TextView[row][col];
        gridaffiche.setRowCount(row);
        gridaffiche.setColumnCount(col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                texts[i][j]=new TextView(this);
                texts[i][j].setText(S[i][j]);
                setPosaffiche1(texts[i][j], i, j);
                gridaffiche.addView(texts[i][j]);
            }}
       LinearLayout lineargrid=(LinearLayout)findViewById(R.id.lineargrid);
       lineargrid.addView(gridaffiche);
    }
    private void setPosaffiche1(TextView textun, int row, int column) {
        GridLayout.LayoutParams param = new GridLayout.LayoutParams();
        param.width = 70;
        param.height = 70;
        param.setGravity(Gravity.CENTER);
        param.rowSpec = GridLayout.spec(row);
        param.columnSpec = GridLayout.spec(column);
        textun.setBackgroundColor(0xFF472562);
        textun.setTextColor(0xFF72D1F1);
        textun.setTextSize(16);
        textun.setLayoutParams(param);
    }
    private void setPosaffiche(TextView textun, int row, int column) {
        GridLayout.LayoutParams param =new GridLayout.LayoutParams();
        param.width = 70;
        param.height = 70;
        param.setGravity(Gravity.CENTER);
        param.rowSpec = GridLayout.spec(row);
        param.columnSpec = GridLayout.spec(column);
        textun.setBackgroundColor(0xFF472562);
        textun.setTextColor(0xFFE1DEE1);
        textun.setTextSize(16);
        textun.setLayoutParams(param);

    }
    //putting the edit text according to row and column index
    private void setPos(EditText editText, int row, int column) {
        GridLayout.LayoutParams param =new GridLayout.LayoutParams();
        param.width = 70;
        param.height = 70;
        param.setGravity(Gravity.CENTER);
        param.rowSpec = GridLayout.spec(row);
        param.columnSpec = GridLayout.spec(column);
        editText.setBackgroundColor(0x84919F);
        editText.setHint("0");
        editText.setHintTextColor(0xFFF4F4F4);
        editText.setInputType(InputType.TYPE_NUMBER_FLAG_SIGNED|InputType.TYPE_NUMBER_FLAG_DECIMAL|InputType.TYPE_CLASS_NUMBER);
        editText.setLayoutParams(param);

    }
       public long fac(int n){
           long l;
           if(n==0||n==1){
               l=1;
           }else l=n*fac(n-1);
           return l;
       }
    public long Comb(int n, int p){
        return fac(n)/(fac(p)*fac(n-p));
    }
    //Création de la fonction déterminant

    private double detA(double[][] T, int a, double x){
        int c=0; det=1;
        if(x!=0){
            for(int i=0; i<a; i++){
                T[i][i]-=x;
            }
        }
        for(int k=1; k<a; k++){
            if(T[k-1][k-1]==0){
                int p=k; double Rec; c++;
                while((p<a)&&T[p][k-1]==0) p++;
                if(p<a){
                    for(int i=0; i<a; i++){
                        Rec=T[p][i]; T[p][i]=T[k-1][i];	T[k-1][i]=Rec;
                    }
                }
            }
            for(int i=k; i<a; i++){
                if(T[k-1][k-1]!=0){
                    double d=T[i][k-1]/T[k-1][k-1];
                    for(int j=k-1; j<a; j++){
                        T[i][j]-=T[k-1][j]*d;
                    }
                }
            }
        }
        for(int i=0; i<a; i++){
            det*=T[i][i];
        }

        return det*Math.pow(-1,c);

    }
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
