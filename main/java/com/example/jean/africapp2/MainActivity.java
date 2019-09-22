package com.example.jean.africapp2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setSubtitle("Afrik apps home");
        ListView liste = (ListView) findViewById(R.id.liste);
        ArrayList<String> rubriques=new ArrayList<String>();
        rubriques.add("Calcul matriciel");
        rubriques.add("Calcul de limites de fonctions");
        rubriques.add("Résolution d'une équation quelconque f(x)=0");
        rubriques.add("Résolution de Système d'équation linéaire");
        rubriques.add("Décomposition en élements premiers");
        rubriques.add("Produit Factoriel");
        rubriques.add("Arrangement");
        rubriques.add("p-uplet ou p-listes");
        rubriques.add("Combinaison");
        rubriques.add("PPCM de plusieurs nombres");
        rubriques.add("PGCD de plusieurs nombres");
        liste.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,rubriques));
        liste.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int pos, long id){
                if(pos==0){
                    Intent intent=new Intent(MainActivity.this, Matrix.class);
                    startActivity(intent);
                }
                if(pos==1){
                    Intent intent=new Intent(MainActivity.this, Limite.class);
                    startActivity(intent);
                    }
                if(pos==2){
                    Intent intent=new Intent(MainActivity.this, Equation.class);
                    startActivity(intent);
                }
                if(pos==3) {
                    Intent intent=new Intent(MainActivity.this, Systemes.class);
                    startActivity(intent);
                }
                if(pos==4) {
                    Intent intent=new Intent(MainActivity.this, Complement.class);
                    startActivity(intent);
                }
                if(pos==5) {
                    Intent intent=new Intent(MainActivity.this, Complement.class);
                    startActivity(intent);
                }
                if(pos==6) {
                    Intent intent=new Intent(MainActivity.this, Complement.class);
                    startActivity(intent);
                }
                if(pos==7) {
                    Intent intent=new Intent(MainActivity.this, Complement.class);
                    startActivity(intent);
                }
                if(pos==8) {
                    Intent intent=new Intent(MainActivity.this, Complement.class);
                    startActivity(intent);
                }
                if(pos==9) {
                    Intent intent=new Intent(MainActivity.this, Complement.class);
                    startActivity(intent);
                }
                if(pos==10) {
                    Intent intent=new Intent(MainActivity.this, Complement.class);
                    startActivity(intent);
                }
            }

        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.exit){
            Sortir();
            return true;
        }
        if (id == R.id.description) {
            Nous();
            return true;
        }
        if (id == R.id.contact) {
            Appelle();
            return true;
        }
        if(id==R.id.act){
            return true;
        }
        if(id==R.id.off){
            Sortir();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void Sortir(){
        System.exit(0);
    }
    public void Appelle(){
        Uri uri=Uri.parse("tel:+33751500834");
        Intent intent=new Intent(Intent.ACTION_CALL,uri);
        startActivity(intent);
    }
    public void Nous(){
        Intent affiche=new Intent(MainActivity.this,Apropros.class);
        startActivity(affiche);
    }
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
