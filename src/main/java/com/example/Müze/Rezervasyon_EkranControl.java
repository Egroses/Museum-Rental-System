package com.example.yenijavadeneme;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.io.IOException;
import java.sql.Connection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class Rezervasyon_EkranControl implements Initializable {

    String durum=null;
    @FXML
    private JFXTreeTableView<Rezervasyon> tree;
    @FXML
    private JFXCheckBox organizasyon;
    @FXML
    private JFXCheckBox eser_sergisi;
    @FXML
    private JFXCheckBox gezi;
    @FXML
    private JFXCheckBox modern;
    @FXML
    private JFXCheckBox futurist;
    @FXML
    private JFXCheckBox yunan;
    @FXML
    private JFXCheckBox misir;
    @FXML
    private JFXCheckBox postmodern;
    @FXML
    private JFXCheckBox gunes_isigi;
    @FXML
    private JFXCheckBox fiber_optik;
    @FXML
    private JFXCheckBox spot;
    @FXML
    private JFXCheckBox dusuk_sicaklik;
    @FXML
    private JFXCheckBox yuksek_sicaklik;
    @FXML
    private JFXCheckBox musait;
    @FXML
    private JFXCheckBox rezerve;
    @FXML
    private ComboBox<String> combobox;
    ObservableList<String> list= FXCollections.observableArrayList("None","Paris","Berlin","Maçka","Kahire");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        combobox.setItems(list);
        veri_yukle("SELECT * FROM bilgiler");
    }

    public void veri_yukle(String sql){
        JFXTreeTableColumn<Rezervasyon,String> Kategori=new JFXTreeTableColumn<>("Kategori");
        Kategori.setPrefWidth(90);
        Kategori.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Rezervasyon, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Rezervasyon, String> param) {
                return param.getValue().getValue().kategori;
            }
        });
        JFXTreeTableColumn<Rezervasyon,String> Yer=new JFXTreeTableColumn<>("Yer");
        Yer.setPrefWidth(140);
        Yer.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Rezervasyon, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Rezervasyon, String> param) {
                return param.getValue().getValue().yer;
            }
        });
        JFXTreeTableColumn<Rezervasyon,String> Müdür=new JFXTreeTableColumn<>("Müdür");
        Müdür.setPrefWidth(115);
        Müdür.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Rezervasyon, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Rezervasyon, String> param) {
                return param.getValue().getValue().müdür;
            }
        });
        JFXTreeTableColumn<Rezervasyon,String> Mimari=new JFXTreeTableColumn<>("Mimari");
        Mimari.setPrefWidth(145);
        Mimari.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Rezervasyon, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Rezervasyon, String> param) {
                return param.getValue().getValue().mimari;
            }
        });
        JFXTreeTableColumn<Rezervasyon,String> Konum=new JFXTreeTableColumn<>("Konum");
        Konum.setPrefWidth(70);
        Konum.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Rezervasyon, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Rezervasyon, String> param) {
                return param.getValue().getValue().konum;
            }
        });
        JFXTreeTableColumn<Rezervasyon,String> Isiklandirma=new JFXTreeTableColumn<>("Işıklandırma");
        Isiklandirma.setPrefWidth(170);
        Isiklandirma.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Rezervasyon, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Rezervasyon, String> param) {
                return param.getValue().getValue().isiklandirma;
            }
        });
        JFXTreeTableColumn<Rezervasyon,String> Sicaklik=new JFXTreeTableColumn<>("Sıcaklık ve Nem");
        Sicaklik.setPrefWidth(135);
        Sicaklik.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Rezervasyon, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Rezervasyon, String> param) {
                return param.getValue().getValue().sicaklik;
            }
        });
        JFXTreeTableColumn<Rezervasyon,String> Kapasite=new JFXTreeTableColumn<>("Kapasite");
        Kapasite.setPrefWidth(65);
        Kapasite.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Rezervasyon, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Rezervasyon, String> param) {
                return param.getValue().getValue().kapasite;
            }
        });
        JFXTreeTableColumn<Rezervasyon,String> Fiyat=new JFXTreeTableColumn<>("Fiyat");
        Fiyat.setPrefWidth(90);
        Fiyat.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Rezervasyon, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Rezervasyon, String> param) {
                return param.getValue().getValue().fiyat;
            }
        });
        JFXTreeTableColumn<Rezervasyon,String> Durum=new JFXTreeTableColumn<>("Durum");
        Durum.setPrefWidth(70);
        Durum.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Rezervasyon, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Rezervasyon, String> param) {
                return param.getValue().getValue().durum;
            }
        });

        ObservableList<Rezervasyon> rezervasyonlar= FXCollections.observableArrayList();
        Connection connection=DBConnection.getConnection();
        try {
            PreparedStatement ps=(PreparedStatement) connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                rezervasyonlar.add(new Rezervasyon(rs.getString(1)+"",rs.getString(2)+"",rs.getString(3)+"",rs.getString(4)+"",rs.getString(5)+"",rs.getString(6)+"",rs.getString(7)+"",rs.getInt(8)+"",rs.getInt(9)+"",rs.getString(10)+""));
            }
            final TreeItem<Rezervasyon> root = new RecursiveTreeItem<Rezervasyon>(rezervasyonlar, RecursiveTreeObject::getChildren);
            tree.getColumns().setAll(Kategori,Yer,Müdür,Mimari,Konum,Isiklandirma,Sicaklik,Kapasite,Fiyat,Durum);
            tree.setRoot(root);
            tree.setShowRoot(false);
        } catch (SQLException e) {
        }

    }

    @FXML
    public void geri(){
        Stage ana_Ekran = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("Ana_Ekran.fxml"));
        } catch (IOException e) {}

        Stage current = (Stage) gezi.getScene().getWindow();
        Scene scene = new Scene(root, 1300, 800);
        ana_Ekran.setScene(scene);
        ana_Ekran.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        ana_Ekran.show();
    }

    @FXML
    private void search(){
        String sql;
        String kategori="";
        if(organizasyon.isSelected()){
            kategori+="'Organizasyon'";
        }if(eser_sergisi.isSelected()){
            if(organizasyon.isSelected()){
                kategori+=",'Eser Sergisi'";
            }else{
                kategori+="'Eser Sergisi'";
            }
        }if(gezi.isSelected()){
            if(organizasyon.isSelected() || eser_sergisi.isSelected()){
                kategori+=",'Gezi'";
            }else{
                kategori+="'Gezi'";
            }
        }
        if(kategori==""){
            kategori="'Organizasyon','Eser Sergisi','Gezi'";
        }
//--------------------------------------------------------------------------------------------------------
        String mimari="";
        if(modern.isSelected()){
            mimari+="'Modern Mimari'";
        }if(futurist.isSelected()){
            if(modern.isSelected()){
                mimari+=",'Neo Fütürist Mimari'";
            }else{
                mimari+="'Neo Fütürist Mimari'";
            }
        }if(yunan.isSelected()){
            if(modern.isSelected() || futurist.isSelected()){
                mimari+=",'Yunan ve Roma Mimarisi'";
            }else{
                mimari+="'Yunan ve Roma Mimarisi'";
            }
        }if(misir.isSelected()){
            if(modern.isSelected() || futurist.isSelected()|| yunan.isSelected()){
                mimari+=",'Mısır Mimarisi'";
            }else{
                mimari+="'Mısır Mimarisi'";
            }
        }if(postmodern.isSelected()){
            if(modern.isSelected() || futurist.isSelected()|| yunan.isSelected()|| misir.isSelected()){
                mimari+=",'Postmodern Mimari'";
            }else{
                mimari+="'Postmodern Mimari'";
            }
        }
        if(mimari==""){
            mimari="'Modern Mimari','Neo Fütürist Mimari','Yunan ve Roma Mimarisi','Mısır Mimarisi','Postmodern Mimari'";
        }
//--------------------------------------------------------------------------------------------------------
        String isiklandirma="";
        if(gunes_isigi.isSelected()){
            isiklandirma+="'Doğal Güneş Işığı'";
        }if(fiber_optik.isSelected()){
            if(gunes_isigi.isSelected()){
                isiklandirma+=",'Fiber Optik Aydınlatma'";
            }else{
                isiklandirma+="'Fiber Optik Aydınlatma'";
            }
        }
        if(spot.isSelected()){
            if(gunes_isigi.isSelected()||fiber_optik.isSelected()){
                isiklandirma+=",'Ray-Monteli Spot Aydınlatma'";
            }else{
                isiklandirma+="'Ray-Monteli Spot Aydınlatma'";
            }
        }
        if(isiklandirma==""){
            isiklandirma="'Doğal Güneş Işığı','Fiber Optik Aydınlatma','Ray-Monteli Spot Aydınlatma'";
        }
//--------------------------------------------------------------------------------------------------------
        String sicaklik="";
        if(dusuk_sicaklik.isSelected()){
            sicaklik+="'18 derece ve %50 nem'";
        }if(yuksek_sicaklik.isSelected()){
            if(dusuk_sicaklik.isSelected()){
                sicaklik+=",'20 derece ve %40 nem'";
            }else{
                sicaklik+="'20 derece ve %40 nem'";
            }
        }
        if(sicaklik==""){
            sicaklik="'18 derece ve %50 nem','20 derece ve %40 nem'";
        }
//--------------------------------------------------------------------------------------------------------
        String konum=combobox.getValue();
        if(konum==null||konum=="None"){
            konum="'Paris','Berlin','Maçka','Kahire'";
        }else{
            konum="'"+konum+"'";
        }
//--------------------------------------------------------------------------------------------------------
        String durum="";
        if(musait.isSelected()){
            durum+="'Müsait'";
        }if(rezerve.isSelected()){
            if(musait.isSelected()){
                durum+=",'Rezerve'";
            }else{
                durum+="'Rezerve'";
            }
        }
        if(durum==""){
            durum="'Müsait','Rezerve'";
        }


        sql="SELECT * FROM bilgiler Where kategori IN("+kategori+") AND mimari IN("+mimari+") AND konum IN("+konum+") AND isiklandirma IN("+isiklandirma+") AND sicaklik IN("+sicaklik+") AND durum IN("+durum+")";
        veri_yukle(sql);
    }

}
