package com.example.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @web http://java-buddy.blogspot.com
 */

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Search.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            primaryStage.setTitle("i192029");
            primaryStage.setScene(scene);
            primaryStage.show();

    }

}

