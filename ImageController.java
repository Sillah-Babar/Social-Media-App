package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;


public class ImageController implements Initializable {

        @FXML
        private ImageView image;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public  void setData(dashboardImages p) {


        Image image = null;
        try {
            System.out.println(p.getImgPath());

            image = new Image(this.getClass().getResourceAsStream("pictures/"+p.getImgPath()));
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }

        this.image.setImage(image);
    }
}


