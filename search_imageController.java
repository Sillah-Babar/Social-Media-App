package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class search_imageController {

    @FXML
    private ImageView image;

    @FXML
    private Label interest;

    @FXML
    private Label bio;

    @FXML
    private Button sendRequest;

    @FXML
    private Label username;

    Integer sendre;

    public void setSendre(Integer sendre) {
        this.sendre = sendre;
    }

    public Integer getSendre() {
        return sendre;
    }

    @FXML
    void actionHandled(ActionEvent event) {
      if(event.getSource()==sendRequest)
      {
       sendre=1;
      }
    }


    public  void setData(profile_data p,String Interest) {

            sendre=0;

            this.interest.setText(Interest);
            this.username.setText(p.getUsername());
            this.bio.setText(p.getBio());
            Image image = null;
            try {
                System.out.println(p.getProfilepic());

                image = new Image(this.getClass().getResourceAsStream("connections/" + p.getProfilepic()));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            this.image.setImage(image);

    }
}

