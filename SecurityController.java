package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.net.URL;
import java.util.ResourceBundle;

public class SecurityController implements Initializable {

    @FXML
    private Button applychanges;

    @FXML
    private TextField current;

    @FXML
    private TextField newpass;

    @FXML
    private ImageView profilePic;

    @FXML
    private TextField renternewpass;

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


    @FXML
    void changepassword(ActionEvent ev)
    {
        if(ev.getSource()==applychanges)
        {
           String currentpass= current.getText();
           String pass=newpass.getText();
           String repass=renternewpass.getText();
           if(pass.equals(repass))
           {
               Profile newp;
               newp=Profile.getInstance();
               if(currentpass.equals(newp.getPasswr()))
               {
                   newp.setPasswr(pass);
                   showmessage.setText("Password Updated");
               }
               else
               {
                   showmessage.setText("The Current Password is Wrong");
               }
           }
           else
           {
               showmessage.setText("The new Password does not match the renentered password");
           }
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

