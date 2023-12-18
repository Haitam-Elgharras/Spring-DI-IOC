package ma.enset;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class JavaFxApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // load the form.fxml file
        File file = new File("src/main/java/ma/enset/form.fxml");
        URL url = file.toURI().toURL();
        BorderPane root = FXMLLoader.load(url);

        // set the title of the window
        primaryStage.setTitle("JavaFX App");

        // set the scene of the window
        primaryStage.setScene(new Scene(root, 800, 600));

        // show the window
        primaryStage.show();
    }
}
