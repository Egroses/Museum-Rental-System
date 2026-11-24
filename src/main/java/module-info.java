module com.example.yenijavadeneme {
    requires javafx.controls;
    requires javafx.fxml;
    requires controlsfx;
    requires com.jfoenix;
    requires java.sql;


    opens com.example.yenijavadeneme to javafx.fxml;
    exports com.example.yenijavadeneme;
}