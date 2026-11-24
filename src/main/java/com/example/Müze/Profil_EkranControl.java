package com.example.yenijavadeneme;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;



public class Profil_EkranControl implements Initializable {

    @FXML
    private Label ad;
    @FXML
    private Label soyad;
    @FXML
    private Label email;
    @FXML
    private Label statu;
    @FXML
    private Label telefon;
    @FXML
    private Label sehir;
    @FXML
    private Label yer;
    @FXML
    private Label amac;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String sql="Select * FROM uyeler WHERE giris_durumu='Pozitif'";
        Connection connection=DBConnection.getConnection();
        try {
            PreparedStatement ps=(PreparedStatement) connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                ad.setText(rs.getString(1));
                soyad.setText(rs.getString(2));
                email.setText(rs.getString(4));
                statu.setText(rs.getString(5));
                telefon.setText(rs.getString(6));
                sehir.setText(rs.getString(7));
                yer.setText(rs.getString(8));
                amac.setText(rs.getString(9));
            }} catch (SQLException e) {}

    }

    @FXML
    public void geri(){
        Stage ana_Ekran = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("Ana_Ekran.fxml"));
        } catch (IOException e) {}

        Stage current = (Stage) ad.getScene().getWindow();
        Scene scene = new Scene(root, 1300, 800);
        ana_Ekran.setScene(scene);
        ana_Ekran.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        ana_Ekran.show();
    }
}