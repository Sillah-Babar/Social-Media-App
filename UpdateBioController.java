package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateBioController {

    @FXML
    private Button applychanges;

    @FXML
    private TextField bio;

    @FXML
    private ImageView profilePic;

    @FXML
    private Button returnToProfile;

    @FXML
    private ListView<String> settings;

    @FXML
    private Label showmessage;
    private Stage primaryStage;

    @FXML
    void actionHandled(ActionEvent event) throws IOException {
        if(event.getSource()==returnToProfile)
        {
            changeScene("Menu.fxml",  event);
        }
        else if(event.getSource()==applychanges)
        {
            String text=bio.getText();
            Profile pf;
            pf=Profile.getInstance();
            pf.setBio(text);
            showmessage.setText("Your Profile Bio has been updated");
        }

    }
    //Generic function to change scene
    public void changeScene(String fxml, ActionEvent event) throws IOException {

        //------Following code changes scene to Schedule-------
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        this.primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        //-----------------------------------------------------

    }


}

