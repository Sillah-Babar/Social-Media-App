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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {

    @FXML
    private TextField Username;

    @FXML
    private Label messagebox;

    @FXML
    private TextField password;

    @FXML
    private Button signup;
    @FXML
    private Button login;
    private Stage primaryStage;

    @FXML
    void actionHandled(ActionEvent event) throws IOException {
        if(event.getSource()==signup)
        {
            changeScene("signup.fxml",event);
        }
        else if(event.getSource()==login)
        {
            Database db;
            db=Database.getInstance();
            profile_data pf=db.SearchProfile(Username.getText(),password.getText());
            if(pf==null)
            {
                messagebox.setText("No such Profile Exists");
            }
            else
            {
                Profile curr;
                curr=Profile.getInstance();
                curr.setProfile(pf);
                Integer k=db.getIndex(pf);
                System.out.println(Profile.getInstance());
                System.out.println(Profile.getInstance().id);
                System.out.println(Profile.getInstance().getProfilepic());
                //db.getProfiles().remove(k);
                changeScene("Menu.fxml",event);
            }

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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

