module ma.enset {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.persistence;
    requires spring.context;
    requires spring.beans;

    exports ma.enset.service;
    // or opens ... to ...
    opens ma.enset.service;
    exports ma.enset.dao;
    opens ma.enset to javafx.fxml;
    opens ma.enset.dao.entities to javafx.base;
    exports ma.enset;
}