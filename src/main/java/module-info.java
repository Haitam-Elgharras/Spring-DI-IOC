module ma.enset {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.persistence;

    opens ma.enset to javafx.fxml;
    opens ma.enset.dao.entities to javafx.base;
    exports ma.enset;
}