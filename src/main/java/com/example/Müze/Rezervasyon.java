package com.example.yenijavadeneme;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Rezervasyon extends RecursiveTreeObject<Rezervasyon> {

    StringProperty kategori;
    StringProperty yer;
    StringProperty müdür;
    StringProperty mimari;
    StringProperty konum;
    StringProperty isiklandirma;
    StringProperty sicaklik;
    StringProperty kapasite;
    StringProperty fiyat;
    StringProperty durum;
    public Rezervasyon(){
        super();
    }
    public Rezervasyon(String kategori,String yer,String müdür,String mimari,String konum,String isiklandirma,String sicaklik,String kapasite,String fiyat,String durum){
        this.kategori=new SimpleStringProperty(kategori);
        this.yer=new SimpleStringProperty(yer);
        this.müdür=new SimpleStringProperty(müdür);
        this.mimari=new SimpleStringProperty(mimari);
        this.konum=new SimpleStringProperty(konum);
        this.isiklandirma=new SimpleStringProperty(isiklandirma);
        this.sicaklik=new SimpleStringProperty(sicaklik);
        this.kapasite=new SimpleStringProperty(kapasite);
        this.fiyat=new SimpleStringProperty(fiyat);
        this.durum=new SimpleStringProperty(durum);
    }

}
