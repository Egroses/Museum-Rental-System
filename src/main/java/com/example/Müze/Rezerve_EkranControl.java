package com.example.yenijavadeneme;

import com.jfoenix.controls.JFXCheckBox;
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

public class Rezerve_EkranControl implements Initializable {

    @FXML
    private Label yer;
    @FXML
    private Label kategori;
    @FXML
    private Label mudur;
    @FXML
    private Label konum;
    @FXML
    private Label mimari;
    @FXML
    private Label kapasite;
    @FXML
    private Label isiklandirma;
    @FXML
    private Label sicaklik;
    @FXML
    private TextField rezerve_yer;
    @FXML
    private TextField rezerve_kategori;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        veri_yukle();
    }

    public void veri_yukle(){
        Connection connection=DBConnection.getConnection();
        String muze_kontrol="";
        String kategori_kontrol="";
        String sql="Select * FROM uyeler WHERE giris_durumu='Pozitif'";
        try {
            PreparedStatement ps=(PreparedStatement) connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                kategori_kontrol=rs.getString(8);
                muze_kontrol=rs.getString(9);
            }
            if((!kategori_kontrol.equals("None"))||(!muze_kontrol.equals("None"))){

                String veri_cek="Select * FROM bilgiler WHERE yer='"+muze_kontrol+"' AND kategori='"+kategori_kontrol+"'";
                try {
                    PreparedStatement veri_cekici=(PreparedStatement) connection.prepareStatement(sql);
                    ResultSet list=ps.executeQuery();
                    while (list.next()){
                        kategori.setText(list.getString(1));
                        yer.setText(list.getString(2));
                        mudur.setText(list.getString(3));
                        mimari.setText(list.getString(4));
                        konum.setText(list.getString(5));
                        isiklandirma.setText(list.getString(6));
                        sicaklik.setText(list.getString(7));
                        kapasite.setText(list.getString(8));
                    }


                } catch (SQLException e) {}

            }
        } catch (SQLException e) {}
    }


    @FXML
    public void rezervasyon_yap(){
        Connection connection=DBConnection.getConnection();


        if(rezerve_yer.getText().toString().trim().equals("")){
            rezerve_yer.setText("");
        }
        else if(rezerve_kategori.getText().toString().trim().equals("")){
            rezerve_kategori.setText("");
        }
        else{

            String sql="Select * FROM bilgiler WHERE yer='"+rezerve_yer.getText().toString().trim()+"' AND kategori='"+rezerve_kategori.getText()+"' AND durum='Müsait'";
            try {
                PreparedStatement ps=(PreparedStatement) connection.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                while (rs.next()){
                    kategori.setText(rs.getString(1));
                    yer.setText(rs.getString(2));
                    mudur.setText(rs.getString(3));
                    mimari.setText(rs.getString(4));
                    konum.setText(rs.getString(5));
                    isiklandirma.setText(rs.getString(6));
                    sicaklik.setText(rs.getString(7));
                    kapasite.setText(rs.getString(8));
                }
                String uye_icin="UPDATE uyeler SET kategori='"+rezerve_kategori.getText()+"',muze='"+rezerve_yer.getText()+"' WHERE giris_durumu='Pozitif'";
                String bilgi_icin="UPDATE bilgiler SET durum='Rezerve' WHERE yer='"+rezerve_yer.getText().toString().trim()+"' AND kategori='"+rezerve_kategori.getText()+"'";
                try {
                    Statement statement=connection.createStatement();
                    statement.executeUpdate(uye_icin);
                    statement.executeUpdate(bilgi_icin);
                } catch (SQLException ex) {}

            } catch (SQLException e) {}
        }}

    @FXML
    public void rezervasyon_iptal(){
        Connection connection=DBConnection.getConnection();
        String muze_kontrol="";
        String kategori_kontrol="";
        String sql="Select * FROM uyeler WHERE giris_durumu='Pozitif'";
        try {
            PreparedStatement ps=(PreparedStatement) connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                kategori_kontrol=rs.getString(8);
                muze_kontrol=rs.getString(9);
            }
            if((!kategori_kontrol.equals("None"))||(!muze_kontrol.equals("None"))){
                String uye_icin="UPDATE uyeler SET kategori='None',muze='None' WHERE giris_durumu='Pozitif'";
                String bilgi_icin="UPDATE bilgiler SET durum='Müsait' WHERE yer='"+muze_kontrol+"' AND kategori='"+kategori_kontrol+"'";
                try {
                    Statement statement=connection.createStatement();
                    statement.executeUpdate(uye_icin);
                    statement.executeUpdate(bilgi_icin);
                } catch (SQLException ex) {}
                kategori.setText("");
                yer.setText("");
                mudur.setText("");
                mimari.setText("");
                konum.setText("");
                isiklandirma.setText("");
                sicaklik.setText("");
                kapasite.setText("");
                rezerve_yer.setText("");
                rezerve_kategori.setText("");
            }
        } catch (SQLException e) {}
    }

    @FXML
    public void geri(){
        Stage ana_Ekran = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("Ana_Ekran.fxml"));
        } catch (IOException e) {}

        Stage current = (Stage) yer.getScene().getWindow();
        Scene scene = new Scene(root, 1300, 800);
        ana_Ekran.setScene(scene);
        ana_Ekran.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        ana_Ekran.show();
    }
}