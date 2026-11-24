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

public class Giris_EkranControl implements Initializable {

    @FXML
    private TextField kullanici_adi;
    @FXML
    private TextField sifre;
    @FXML
    private Label hata;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    public void giris_enter(){
        giris_Yap();
    }

    @FXML
    public void giris_Yap(){
        Connection connection=DBConnection.getConnection();
        String giris_durumu_sifirla="UPDATE uyeler SET giris_durumu='Negatif' WHERE 1";
        try {
            Statement durum=connection.createStatement();
            durum.executeUpdate(giris_durumu_sifirla);
        } catch (SQLException ex) {}
        boolean devam=false;

        if(kullanici_adi.getText().toString().trim().equals("")){
            hata.setText("Kullanıcı adı boş bırakılamaz!");
        }
        else if(sifre.getText().toString().trim().equals("")){
            hata.setText("Şifre bölümü boş bırakılamaz!");
        }
        else{

            String sifredata="";
            String sql="Select * FROM uyeler WHERE ad='"+kullanici_adi.getText().toString().trim()+"'";

            try {
                PreparedStatement ps=(PreparedStatement) connection.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                while (rs.next()){
                    devam=true;
                    sifredata=rs.getString(3);
                }
                if(devam==true){
                    if (sifre.getText().toString().trim().equals(sifredata)) {
                        String update="UPDATE uyeler SET giris_durumu='Pozitif' WHERE ad='"+kullanici_adi.getText().toString().trim()+"'";
                        try {
                            Statement statement=connection.createStatement();
                            statement.executeUpdate(update);
                        } catch (SQLException ex) {}
                        Stage ana_Ekran = new Stage();
                        Parent root = null;

                        try {
                            root = FXMLLoader.load(getClass().getResource("Ana_Ekran.fxml"));
                        } catch (IOException e) {}

                        Stage current = (Stage) kullanici_adi.getScene().getWindow();
                        Scene scene = new Scene(root, 1300, 800);
                        ana_Ekran.setScene(scene);
                        ana_Ekran.initStyle(StageStyle.TRANSPARENT);
                        current.hide();
                        ana_Ekran.show();

                    }}} catch (SQLException e) {}
            if(devam==false){
                hata.setText("Kullanıcı adı veya şifre hatalı!");
            }
            devam=false;
    }}

    @FXML
    public void kayit_ol(){
        Stage ana_Ekran = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("Kayit_Ekran.fxml"));
        } catch (IOException e) {}

        Stage current = (Stage) kullanici_adi.getScene().getWindow();
        Scene scene = new Scene(root);
        ana_Ekran.setScene(scene);
        ana_Ekran.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        ana_Ekran.show();
    }
    @FXML
    public void iptal(){
        System.exit(0);
    }
}