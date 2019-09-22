package com.example.jean.africapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Matrix extends AppCompatActivity {
    private ListView liste = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setSubtitle("Afrik apps home");
        liste = (ListView) findViewById(R.id.liste);
        ArrayList<String> liste1 = new ArrayList<String>();
        liste1.add("                               CLICK HERE ");
        liste1.add("Somme de matrix");
        liste1.add("Produit de matrix");
        liste1.add("Déterminant de matrix");
        liste1.add("Polynome caractéristique de matrice");
        liste1.add("Inverse de matrix");
        liste.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, liste1));
        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int pos, long id) {
                if (pos == 1) {

                    Intent intent = new Intent(Matrix.this, Matrix1.class);
                    intent.putExtra("position", pos);
                    startActivity(intent);
                }
                if (pos == 2) {

                    Intent intent = new Intent(Matrix.this, Matrix1.class);
                    intent.putExtra("position", pos);
                    startActivity(intent);
                }
                if (pos == 3) {

                    Intent intent = new Intent(Matrix.this, Matrix1.class);
                    intent.putExtra("position", pos);
                    startActivity(intent);
                }
                if (pos == 4) {

                    Intent intent = new Intent(Matrix.this, Matrix1.class);
                    intent.putExtra("position", pos);
                    startActivity(intent);
                }
                if (pos == 5) {
                    Intent intent = new Intent(Matrix.this, Matrix1.class);
                    intent.putExtra("position", pos);
                    startActivity(intent);
                }
            }
        });

    }
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
