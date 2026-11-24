package com.example.yenijavadeneme;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.StackPane;


public class Ana_EkranControl implements Initializable {

    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;
    @FXML
    private Pane pane4;
    @FXML
    private Pane pane5;

    @FXML
    private void mouse_enter_1(MouseEvent event){
        pane1.setStyle("-fx-background-color: #f0f400; -fx-background-radius: 6px");
    }
    @FXML
    private void mouse_leave_1(MouseEvent event){
        pane1.setStyle("-fx-background-color: #09e2a7; -fx-background-radius: 6px");
    }
    @FXML
    private void mouse_enter_2(MouseEvent event){
        pane2.setStyle("-fx-background-color: #f0f400; -fx-background-radius: 6px");
    }
    @FXML
    private void mouse_leave_2(MouseEvent event){
        pane2.setStyle("-fx-background-color: #09e2a7; -fx-background-radius: 6px");
    }
    @FXML
    private void mouse_enter_3(MouseEvent event){
        pane3.setStyle("-fx-background-color: #f0f400; -fx-background-radius: 6px");
    }
    @FXML
    private void mouse_leave_3(MouseEvent event){
        pane3.setStyle("-fx-background-color: #09e2a7; -fx-background-radius: 6px");
    }
    @FXML
    private void mouse_enter_4(MouseEvent event){
        pane4.setStyle("-fx-background-color: #f0f400; -fx-background-radius: 6px");
    }
    @FXML
    private void mouse_leave_4(MouseEvent event){
        pane4.setStyle("-fx-background-color: #09e2a7; -fx-background-radius: 6px");
    }
    @FXML
    private void mouse_enter_5(MouseEvent event){
        pane5.setStyle("-fx-background-color: #f0f400; -fx-background-radius: 6px");
    }
    @FXML
    private void mouse_leave_5(MouseEvent event){
        pane5.setStyle("-fx-background-color: #09e2a7; -fx-background-radius: 6px");
    }
    @FXML
    private void  pane_click_1(){
        Stage revervasyon_ekran = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("Rezervasyon_Ekran.fxml"));
        } catch (IOException e) {
        }

        Stage current = (Stage) pane1.getScene().getWindow();
        Scene scene = new Scene(root, 1430, 880);
        revervasyon_ekran.setScene(scene);
        revervasyon_ekran.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        revervasyon_ekran.show();
    }
    @FXML
    private void  pane_click_2(){
        Stage profil_ekran = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("Rezerve_Ekran.fxml"));
        } catch (IOException e) {
        }

        Stage current = (Stage) pane2.getScene().getWindow();
        Scene scene = new Scene(root);
        profil_ekran.setScene(scene);
        profil_ekran.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        profil_ekran.show();
    }
    @FXML
    private void  pane_click_3(){
        Stage profil_ekran = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("Profil_Ekran.fxml"));
        } catch (IOException e) {
        }

        Stage current = (Stage) pane3.getScene().getWindow();
        Scene scene = new Scene(root);
        profil_ekran.setScene(scene);
        profil_ekran.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        profil_ekran.show();
    }
    @FXML
    private void  pane_click_4(){
        Stage home=new Stage();
        Parent root=null;

        try {
            root=FXMLLoader.load(getClass().getResource("Giris_Ekran.fxml"));
        } catch (IOException ex) {
        }

        Stage current=(Stage)pane4.getScene().getWindow();
        Scene scene=new Scene(root);

        home.setScene(scene);
        home.initStyle(StageStyle.TRANSPARENT);

        current.hide();
        home.show();
    }
    @FXML
    private void  pane_click_5(){
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}