package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class NewsfeedImageController implements Initializable {

    @FXML
    private ImageView LikeImage;

    @FXML
    private Button Likebutton;

    @FXML
    private Button comment;

    @FXML
    private CheckBox commentcheckboc;

    @FXML
    private ImageView newspic;

    @FXML
    private ImageView profilepic;

    @FXML
    private Label username;

    @FXML
    private Button viewcomment;

    boolean liked=false;
    @FXML
    void actionHandled(ActionEvent event) {

        if(event.getSource()==Likebutton && liked==false)
        {
            Image image = null;
            try {

                image = new Image(this.getClass().getResourceAsStream("pictures/"+"fullHeart.png"));
            }
            catch(Exception e)
            {
                System.err.println(e.getMessage());
            }

            LikeImage.setImage(image);

            liked=true;
        }
        else if(event.getSource()==Likebutton && liked==true)
        {
            Image image = null;
            try {

                image = new Image(this.getClass().getResourceAsStream("pictures/"+"Heart.png"));
            }
            catch(Exception e)
            {
                System.err.println(e.getMessage());
            }

            LikeImage.setImage(image);

            liked=false;
        }
        else if(event.getSource()==commentcheckboc)
        {
            boolean val=commentcheckboc.isSelected();
            if(val==true)
            {
                comment.setDisable(true);
            }
            else
            {
                comment.setDisable(false);
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       Image image = null;
        try {

            image = new Image(this.getClass().getResourceAsStream("pictures/"+"Heart.png"));
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
        LikeImage.setImage(image);
        liked=false;

    }
    public  void setData(profile_data p) {


        this.username.setText(p.getUsername());

        Image image = null;
        try {
            System.out.println("dhus");

            System.out.println(p.getProfilepic());
            image = new Image(this.getClass().getResourceAsStream("connections/"+p.getProfilepic()));
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
        this.profilepic.setImage(image);

         image = null;
        try {
            String dash="dashboard";
            String id=Integer.toString(p.getId());
            dash+=id;
            dash+="/";
            if(p.dashboardpics.size()>0) {
                image = new Image(this.getClass().getResourceAsStream(dash +p.dashboardpics.get(0)));
            }
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
        this.newspic.setImage(image);
    }
}
