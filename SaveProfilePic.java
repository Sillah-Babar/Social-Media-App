package com.example.project;




import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.imageio.ImageIO;

/**
 *
 * @web http://java-buddy.blogspot.com
 */
public class SaveProfilePic  {



    public void start(Button p) {

        Window window = p.getScene().getWindow();

        Stage primaryStage = (Stage) p.getScene().getWindow();

        final FileChooser fileChooser = new FileChooser();
        final Button openButton = new Button("Open Image");

        final boolean[] done = {false};
        openButton.setOnAction(

                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        setExtFilters(fileChooser);
                        File file = fileChooser.showOpenDialog(primaryStage);
                        if (file != null) {
                            openNewImageWindow(file,primaryStage);

                        }
                    }
                });



        StackPane root = new StackPane();
        root.getChildren().add(openButton);

        Scene scene = new Scene(root, 400, 150);

        primaryStage.setTitle("Bridger");
        primaryStage.setScene(scene);
        primaryStage.show();
        if(done[0]==true)

            return;
    }


    private void setExtFilters(FileChooser chooser){
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
    }

    private void openNewImageWindow(File file,Stage primaryStage){


        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem menuItem_Save = new MenuItem("Save Image");
        menuFile.getItems().addAll(menuItem_Save);
        menuBar.getMenus().addAll(menuFile);
        String n=file.toURI().toString();
        System.out.println(n);
        Label name = new Label(file.getAbsolutePath());
        Image image1 = new Image(file.toURI().toString());
        ImageView imageView = new ImageView();

        int width = 963;    //width of the image
        int height = 640;   //height of the image
        BufferedImage image = null;
        File fp = null;

        //read image
        try{
            fp = new File(file.getAbsolutePath()); //image file path
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            image = ImageIO.read(fp);
            //System.out.println("Reading complete.");
        }catch(IOException e){
            System.out.println("Error: "+e);
        }

        //write image
        try{
            fp = new File("C:\\Users\\silla\\IdeaProjects\\project\\src\\main\\resources\\com\\example\\project\\dashboard_pictures\\profile_pic.png");  //output file path
            ImageIO.write(image, "png", fp);

            System.out.println("Writing complete.");
        }catch(IOException e){
            System.out.println("Error: "+e);
        }

        final VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(0, 10, 0, 10));
        vbox.getChildren().addAll(name, imageView);

        imageView.setFitHeight(400);
        imageView.setPreserveRatio(true);
        imageView.setImage(image1);
        imageView.setSmooth(true);
        imageView.setCache(true);

        Scene scene = new Scene(new VBox(), 400, 350);
        ((VBox)scene.getRoot()).getChildren().addAll(menuBar, vbox);

        primaryStage.setTitle(file.getName());
        primaryStage.setScene(scene);
        primaryStage.show();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Menu.fxml"));
       scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        primaryStage.setTitle("i192029");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}