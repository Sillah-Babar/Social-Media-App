package com.example.project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InterestsController implements Initializable {

    @FXML
    private Button applychanges;

    @FXML
    private ListView<String> interests;

    @FXML
    private ImageView profilePic;

    @FXML
    private Button returnToProfile;

    @FXML
    private ListView<String> settings;
    @FXML
    private Label showmessage;

    private Stage primaryStage;
    ObservableList<String> allinterests = FXCollections.observableArrayList ();

    Interests pf;
    @FXML
    void actionHandled(ActionEvent event) throws IOException {
        if(event.getSource()==returnToProfile)
        {
            changeScene("Menu.fxml",event);
        }
        else if(event.getSource()==applychanges)
        {


            ObservableList selectedIndices = interests.getSelectionModel().getSelectedIndices();
            for(int i=0 ; i<selectedIndices.size() ; i++)
            {
            System.out.println(selectedIndices.get(i));
            }
            if(selectedIndices.size()>5)
            {
                showmessage.setText("you have to select 5 interests only");
            }
            else
            {
                Profile pf;
                pf=Profile.getInstance();
                for(int i=0 ; i<selectedIndices.size() ; i++)
                {
                   String val= allinterests.get((Integer) selectedIndices.get(i));
                    pf.getInterests().add(val);
                    System.out.println( pf.getInterests().get(i));
                }

            }

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        pf=Interests.getInstance();
        //line that has to be removed
        pf.addInterests();

        for(int i=0 ; i< pf.getInterests().size() ; i++)
        {
            allinterests.add(pf.getInterests().get(i));
        }
        interests.setItems(allinterests);
        interests.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
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

