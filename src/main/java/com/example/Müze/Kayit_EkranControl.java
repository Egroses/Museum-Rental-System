package com.example.yenijavadeneme;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Kayit_EkranControl implements Initializable {

    @FXML
    private TextField ad;
    @FXML
    private TextField soyad;
    @FXML
    private TextField email;
    @FXML
    private TextField referans;
    @FXML
    private TextField sifre;
    @FXML
    private TextField tsifre;
    @FXML
    private TextField telefon;
    @FXML
    private TextField sehir;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    public void kayit_enter(){
        ol_kayit();
    }

    @FXML
    public void ol_kayit(){
    if(ad.getText().toString().trim().equals("")){
        ad.setPromptText("Boş bırakılamaz!");
        ad.setText("");
    }else if(soyad.getText().toString().trim().equals("")){
        soyad.setPromptText("Boş bırakılamaz!");
        soyad.setText("");
    }else if(email.getText().toString().trim().equals("")){
        email.setPromptText("Boş bırakılamaz!");
        email.setText("");
    }else if(sifre.getText().toString().trim().equals("")){
        sifre.setPromptText("Boş bırakılamaz!");
        sifre.setText("");
    }else if(tsifre.getText().toString().trim().equals("")){
        tsifre.setPromptText("Boş bırakılamaz!");
        tsifre.setText("");
    }else if(telefon.getText().toString().trim().equals("")){
        telefon.setPromptText("Boş bırakılamaz!");
        telefon.setText("");
    } else if(sehir.getText().toString().trim().equals("")){
        sehir.setPromptText("Boş bırakılamaz!");
        sehir.setText("");
    }else if(!sifre.getText().equals(tsifre.getText())){
        sifre.setPromptText("Şifreler uyuşmuyor!");
        tsifre.setPromptText("Şifreler uyuşmuyor!");
        sifre.setText("");
        tsifre.setText("");
    }
    else {
        String sql;

        if (referans.getText().equals("SK58S")){
            sql = "INSERT INTO uyeler VALUES ('"+ad.getText()+"','"+soyad.getText()+"','"+sifre.getText()+"','"+email.getText()+"','VIP','"+telefon.getText()+"','"+sehir.getText()+"','None','None','Negatif')";
        } else {
            sql = "INSERT INTO uyeler VALUES ('"+ad.getText()+"','"+soyad.getText()+"','"+sifre.getText()+"','"+email.getText()+"','Standart','"+telefon.getText()+"','"+sehir.getText()+"','None','None','Negatif')";
        }

        Connection connection = DBConnection.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
        }

        Stage giris_Ekran = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Giris_Ekran.fxml"));
        } catch (IOException e) {
        }

        Stage current = (Stage) ad.getScene().getWindow();
        Scene scene = new Scene(root,950,750);
        giris_Ekran.setScene(scene);
        giris_Ekran.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        giris_Ekran.show();
    }}

    @FXML
    public void geri(){
        Stage ana_Ekran = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("Giris_Ekran.fxml"));
        } catch (IOException e) {}

        Stage current = (Stage) ad.getScene().getWindow();
        Scene scene = new Scene(root,950,750);
        ana_Ekran.setScene(scene);
        ana_Ekran.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        ana_Ekran.show();
    }
}