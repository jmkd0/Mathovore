package com.example.jean.africapp2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Complement extends AppCompatActivity {
    long[] E=new long[50];
    int k=0;
    long[] F=new long[50];
    int q=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complement);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setSubtitle("Afrik apps home");
        final EditText editdec=(EditText)findViewById(R.id.editdec);
        final TextView textdec1=(TextView)findViewById(R.id.textdec1);
        final Button buttondec=(Button)findViewById(R.id.buttondec);
        final Button buttondec1=(Button)findViewById(R.id.buttondec1);

        final EditText editfac=(EditText)findViewById(R.id.editfac);
        final TextView textfac1=(TextView)findViewById(R.id.textfac1);
        final Button buttonfac=(Button)findViewById(R.id.buttonfac);
        final Button buttonfac1=(Button)findViewById(R.id.buttonfac1);

        final EditText editlis=(EditText)findViewById(R.id.editlis);
        final EditText editlis1=(EditText)findViewById(R.id.editlis1);
        final TextView textlis1=(TextView)findViewById(R.id.textlis1);
        final Button buttonlis=(Button)findViewById(R.id.buttonlis);
        final Button buttonlis1=(Button)findViewById(R.id.buttonlis1);

        final EditText editarr=(EditText)findViewById(R.id.editarr);
        final EditText editarr1=(EditText)findViewById(R.id.editarr1);
        final TextView textarr1=(TextView)findViewById(R.id.textarr1);
        final Button buttonarr=(Button)findViewById(R.id.buttonarr);
        final Button buttonarr1=(Button)findViewById(R.id.buttonarr1);

        final EditText editcom=(EditText)findViewById(R.id.editcom);
        final EditText editcom1=(EditText)findViewById(R.id.editcom1);
        final TextView textcom1=(TextView)findViewById(R.id.textcom1);
        final Button buttoncom=(Button)findViewById(R.id.buttoncom);
        final Button buttoncom1=(Button)findViewById(R.id.buttoncom1);

        final EditText editppcm=(EditText)findViewById(R.id.editppcm);
        final Button buttonppcm=(Button)findViewById(R.id.buttonppcm);
        final Button buttonppcm1=(Button)findViewById(R.id.buttonppcm1);
        final Button buttonppcm2=(Button)findViewById(R.id.buttonppcm2);
        final TextView textppcm2=(TextView)findViewById(R.id.textppcm2);
        final LinearLayout linearppcm=(LinearLayout)findViewById(R.id.linearppcm);

        final EditText editpgcd=(EditText)findViewById(R.id.editpgcd);
        final Button buttonpgcd=(Button)findViewById(R.id.buttonpgcd);
        final Button buttonpgcd1=(Button)findViewById(R.id.buttonpgcd1);
        final Button buttonpgcd2=(Button)findViewById(R.id.buttonpgcd2);
        final TextView textpgcd2=(TextView)findViewById(R.id.textpgcd2);
        final LinearLayout linearpgcd=(LinearLayout)findViewById(R.id.linearpgcd);

        //Decomposition
        buttondec.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String text=editdec.getText().toString();
                if(text.equals("")){
                    Toast.makeText(Complement.this, "Entrez le nombre à décomposer", Toast.LENGTH_LONG).show();
                }else{
                int n=Integer.parseInt(text);
                    String str=Decomp(n);
                    textdec1.setText(n+"="+str);
                }
            }});
        buttondec1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                editdec.setText("");
                textdec1.setText("");
            }});

        //Produit Factoriel
        buttonfac.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String text=editfac.getText().toString();
                if(text.equals("")){
                    Toast.makeText(Complement.this, "Entrez le nombre", Toast.LENGTH_LONG).show();
                }else{
                    long n=Integer.parseInt(text);
                    if(n>20){
                        Toast.makeText(Complement.this, "Entrez un nombre plus plus petit que 21", Toast.LENGTH_LONG).show();
                    }else {
                        long d = Fac(n);
                        textfac1.setText(n + "!=" + String.format("%s", d));
                    }
                }
            }});
        buttonfac1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                editfac.setText("");
                textfac1.setText("");
            }});

        //p-Liste
        buttonlis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String text1=editlis.getText().toString();
                String text2=editlis1.getText().toString();
                if(text1.equals("")||text2.equals("")){
                    Toast.makeText(Complement.this, "Entrez n et(ou) p nombre", Toast.LENGTH_LONG).show();
                }else{
                    long n=Integer.parseInt(text1);
                    long p=Integer.parseInt(text2);
                    double  d=Math.pow(n,p);
                    textlis1.setText(" n^p= "+String.format("%s",d));
                }
            }});
        buttonlis1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                editlis.setText("");
                editlis1.setText("");
                textlis1.setText("");
            }});

        //L' arrangement
        buttonarr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String text1=editarr.getText().toString();
                String text2=editarr1.getText().toString();
                if(text1.equals("")||text2.equals("")){
                    Toast.makeText(Complement.this, "Entrez n et(ou) p ", Toast.LENGTH_LONG).show();
                }else{
                    long n = Integer.parseInt(text1);
                    long p = Integer.parseInt(text2);
                    if(n>=p) {
                        long d = Fac(n) / Fac(n - p);
                        textarr1.setText("A( " + n + ", " + p + " )= " + String.format("%s", d));
                    }else  Toast.makeText(Complement.this, " n doit etre supérieur ou égale à p", Toast.LENGTH_LONG).show();
                }
            }});
        buttonarr1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                editarr.setText("");
                editarr1.setText("");
                textarr1.setText("");
            }});
        //La Combinaison
        buttoncom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String text1=editcom.getText().toString();
                String text2=editcom1.getText().toString();
                if(text1.equals("")||text2.equals("")){
                    Toast.makeText(Complement.this, "Entrez n et(ou) p ", Toast.LENGTH_LONG).show();
                }else{
                    long n = Integer.parseInt(text1);
                    long p = Integer.parseInt(text2);
                    if(n>=p) {
                        long d = Fac(n) / (Fac(n - p)*Fac(p));
                        textcom1.setText("C( " + n + ", " + p + " )= " + String.format("%s", d));
                    }else  Toast.makeText(Complement.this, " n doit etre supérieur ou égale à p", Toast.LENGTH_LONG).show();
                }
            }});
        buttoncom1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                editcom.setText("");
                editcom1.setText("");
                textcom1.setText("");
            }});


        //Calcule du PPCM
        buttonppcm2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String text=editppcm.getText().toString();
                if(text.equals("")){
                    Toast.makeText(Complement.this, "Entrez un nombre", Toast.LENGTH_LONG).show();
                }else {
                    int c=Integer.parseInt(text);
                    if(c>=0) {
                        F[q] = c;
                    }else F[q]=-c;
                    q++;
                    TextView str=new TextView(Complement.this);
                    str.setTextColor(0xFFF9F9F9);
                    str.setTextSize(15);
                    str.setText(text+" ");
                    linearppcm.addView(str);
                    editppcm.setText("");
                }
            }});
        buttonppcm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(q==0){
                    Toast.makeText(Complement.this, "Veuillez entrer un nombres puis cliquez sur Ajouter", Toast.LENGTH_LONG).show();
                }else{
                    for(int i=0; i<q-1; i++){
                        F[i+1]=F[i]*F[i+1]/PGCD(F[i], F[i+1]);
                    }
                    long ppcm=F[q-1];
                    textppcm2.setText("  PPCM= "+ppcm);
                }
            }});
        buttonppcm1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textppcm2.setText("");
                linearppcm.removeAllViews();
                q=0;
            }});

        //Calcule du PGCD
        buttonpgcd2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String text=editpgcd.getText().toString();
                if(text.equals("")){
                    Toast.makeText(Complement.this, "Entrez un nombre", Toast.LENGTH_LONG).show();
                }else {
                    int c=Integer.parseInt(text);
                    if(c>=0) {
                        E[k] = c;
                    }else E[k]=-c;
                    k++;
                    TextView str=new TextView(Complement.this);
                    str.setTextColor(0xFFF9F9F9);
                    str.setTextSize(15);
                    str.setText(text+" ");
                    linearpgcd.addView(str);
                    editpgcd.setText("");
                }
            }});
        buttonpgcd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(k==0){
                    Toast.makeText(Complement.this, "Veuillez entrer un nombres puis cliquez sur Ajouter", Toast.LENGTH_LONG).show();
                }else{
                    for(int i=0; i<k-1; i++){
                        E[i+1]=PGCD(E[i], E[i+1]);
                    }
                    long pgcd=E[k-1];
                    textpgcd2.setText("  PGCD= "+pgcd);
                }
            }});
        buttonpgcd1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textpgcd2.setText("");
                linearpgcd.removeAllViews();
                k=0;
            }});
    }

    //Les procedures
    public Long Fac(long n){
        long fac;
        if(n==0||n==1) {
            fac = 1;
        }else fac=n*Fac(n-1);
        return fac;
    }

    public String Decomp(long n){
        String S="1";
        long d=n, b=n;
        for(long i=2; i<=n; i++){
            long k=0;
            while(d%i==0){
                k++; d=d/i;
            }
            if(b%i==0){
                if(k==1){
                    S=S+"*"+String.format("%s",i);
                }else S=S+"*"+String.format("%s",i)+"^"+String.format("%s",k);
                b=d;
            }
        }
        return S;
    }
    public Long PGCD(long a, long b) {
        long pgcd;
        while (a * b != 0) {
            if (a > b) {
                a = a - b;
            } else b = b - a;
        }

        if (a == 0) {
            pgcd = b;
        }else pgcd=a;
        return pgcd;
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
