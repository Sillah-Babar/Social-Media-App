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

public class signupController implements Initializable {

    @FXML
    private TextField Username;

    @FXML
    private TextField confirmpass;

    @FXML
    private Button login;

    @FXML
    private Label messagebox;

    @FXML
    private TextField password;

    @FXML
    private Button signup;
    private Stage primaryStage;

    @FXML
    void actionHandled(ActionEvent event) throws IOException {
        if(event.getSource()==signup)
        {
            if(password.getText().equals(confirmpass.getText()))
            {
                Database db;
                db=Database.getInstance();
                profile_data pf=new profile_data();
                pf.setUsername(Username.getText());
                pf.setPasswr(password.getText());
                db.add(pf);
                messagebox.setText("Your account has been successfully created. Login to access it");
                Username.setText("");
                password.setText("");
                confirmpass.setText("");


            }
            else
            {
                messagebox.setText("The password you have entered does not match");
            }
        }
        else if(event.getSource()==login)
        {
            changeScene("login.fxml",event);
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
