module com.example.javafxrana {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
   requires animatefx;
    requires com.jfoenix;
    requires fontawesomefx;
    requires java.sql;

    opens com.example.javafxrana.entities to javafx.base;
    opens com.example.javafxrana to javafx.fxml;
    exports com.example.javafxrana;
}