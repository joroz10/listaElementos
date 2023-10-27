package com.example.listaelementos.models;

import com.example.listaelementos.app.MyApplication;

import io.realm.RealmObject;

public class Creature extends RealmObject {
    private int id;
    public String name;
    public String description;
    public int drawable;
    public String colorNombre;
    public String colorImagen;

    public Creature(){}
    public Creature(String name, String description, int drawable, String colorNombre, String colorImagen){
        this.id = MyApplication.elementId.getAndIncrement();
        this.name = name;
        this.description = description;
        this.drawable = drawable;
        this.colorNombre = colorNombre;
        this.colorImagen = colorImagen;
    }
}
