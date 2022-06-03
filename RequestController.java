package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class RequestController implements Initializable {

    int req;
    @FXML
    private Button accept;

    @FXML
    private Label bio;

    @FXML
    private Button decline;

    @FXML
    private ImageView image;

    @FXML
    private Label interest;

    @FXML
    private Label interest1;

    @FXML
    private Label username;

    @FXML
    void actionHandled(ActionEvent event) {

        if(event.getSource()==accept)
        {
           req=1;
        }
        else
        {
            req=0;
        }

    }
    public  void setData(profile_data p) {

        this.username.setText(p.getUsername());
        this.bio.setText(p.getBio());
        Image image = null;
        try {
            //System.out.println(p.getProfilePicPath());

            image = new Image(this.getClass().getResourceAsStream("connections/"+p.getProfilepic()));
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }

        this.image.setImage(image);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        req=4;
    }
}
