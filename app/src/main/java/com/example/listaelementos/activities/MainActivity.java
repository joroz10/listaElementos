package com.example.listaelementos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.listaelementos.R;
import com.example.listaelementos.adapters.RecyclerDataAdapter;
import com.example.listaelementos.models.Creature;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    EditText txtSearch;
    RecyclerView recyclerView;
    Realm realm;
    RecyclerDataAdapter recyclerDataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();

        txtSearch = (EditText) findViewById(R.id.txtSearch);
        recyclerView = (RecyclerView) findViewById(R.id.rcvMain);

        List finalList = new ArrayList();

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(new Creature("Pirata","Es un pirata",R.drawable._19_pirate,"FF27B8B3", "FF73DFDB"));
        realm.copyToRealmOrUpdate(new Creature("Alien","Es un alien",R.drawable._14_alien,"FFD8BE11", "FFD1C365"));
        realm.copyToRealmOrUpdate(new Creature("Grifo","Es un grifo",R.drawable._27_gryphon,"FF701360", "FFD57BC5"));
        realm.copyToRealmOrUpdate(new Creature("Hydra","Es una hydra",R.drawable._36_hydra,"FF981A43", "FFAF486A"));
        realm.copyToRealmOrUpdate(new Creature("Zombi","Es un zombi",R.drawable._41_zombie,"FF27B8B3", "FF73DFDB"));
        realm.copyToRealmOrUpdate(new Creature("Pegaso","Es un pegaso",R.drawable._38_pegasus,"FFD8BE11", "FFD1C365"));
        realm.copyToRealmOrUpdate(new Creature("Fantasma","Es un fantasma",R.drawable._48_ghost,"FF701360", "FFD57BC5"));
        realm.copyToRealmOrUpdate(new Creature("Mago","Es un mago",R.drawable._49_wizard,"FF981A43", "FFAF486A"));
        realm.commitTransaction();


        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                List list = new ArrayList();
                list = realm.where(Creature.class).findAll();
                finalList.clear();
                for (Object o:list) {
                    Creature p = (Creature) o;
                    if(p.name.startsWith(txtSearch.getText().toString())){
                        finalList.add(p);
                    }
                }
                recyclerDataAdapter = new RecyclerDataAdapter(finalList, new RecyclerDataAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Creature p, int position) {
                        Intent intent = new Intent(MainActivity.this, ElementActivity.class);
                        intent.putExtra("img",p.drawable);
                        intent.putExtra("desc",p.description);
                        intent.putExtra("name",p.name);
                        startActivity(intent);
                    }
                });
                recyclerView.setAdapter(recyclerDataAdapter);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }
}
