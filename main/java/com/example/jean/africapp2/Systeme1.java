package com.example.jean.africapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Systeme1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_systeme1);
        final LinearLayout equa11=(LinearLayout)findViewById(R.id.equa11);
        final LinearLayout solu22=(LinearLayout)findViewById(R.id.solu22);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setSubtitle("Afrik apps home");
        final Bundle importe=this.getIntent().getExtras();
        final Button button=(Button)findViewById(R.id.button);
         String[] Da=new String[6];
        String[] S=new String[6];
        int   k=importe.getInt("solutionsindex");
        int   d=importe.getInt("equationsindex");
        for(int i=0; i<d; i++){
           Da[i]=importe.getString("1"+String.format("%s",i));
            TextView text=new TextView(Systeme1.this);
            text.setTextColor(0xFFE9DBEA);
            text.setTextSize(16);
            text.setText(Da[i]);
            equa11.addView(text);
        }
        for(int i=0; i<k; i++){
            S[i]=importe.getString("2"+String.format("%s",i));
            TextView text1=new TextView(Systeme1.this);
            text1.setTextColor(0xFFE9DBEA);
            text1.setTextSize(16);
            text1.setText(S[i]);
            solu22.addView(text1);
        }
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                equa11.removeAllViews();
                solu22.removeAllViews();
                Systeme1.this.finish();
            }});

    }
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
