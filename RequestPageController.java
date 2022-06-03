package com.example.project;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RequestPageController implements Initializable {

    @FXML
    private ScrollPane MenuScroll;

    @FXML
    private GridPane grid;

    @FXML
    private ImageView profilePic;

    @FXML
    private Button returnbutton;

    @FXML
    private ListView<?> settings;
    private Stage primaryStage;

    ArrayList<RequestController> requestControllers;
    ArrayList<profile_data> profiles;
    Profile pf;
    @FXML
    void HoverHandled(MouseEvent event) {
        RemoveRequests();

    }
    //helper function to test code
    public void addProfiles()
    {
        Database db;
        db=Database.getInstance();
        profiles=db.getRequests(pf);

    }


    private void RemoveRequests()
    {
        for(int i=0 ; i<profiles.size() ; i++)
        {
            if(requestControllers.get(i).req!=4) {
                profiles.remove(i);
                requestControllers.remove(i);
                grid.getChildren().remove(i);
            }

        }
    }
    @FXML
    void actionHandled(ActionEvent event) throws IOException {
        if(event.getSource()==returnbutton)
        {
            changeScene("Menu.fxml",  event);
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        profiles=new ArrayList<profile_data>();
        requestControllers=new ArrayList<RequestController>();
        pf=Profile.getInstance();
        addProfiles();
        System.out.println("requests");
        System.out.println(profiles.size());


        int column = 0;
        int row = 1;

        try {
            for(int i = 0; i < profiles.size(); ++i)
            {
                FXMLLoader fxmlLoader2 = new FXMLLoader();
                fxmlLoader2.setLocation(this.getClass().getResource("Request.fxml"));
                AnchorPane anchorPane = null;

                anchorPane = (AnchorPane)fxmlLoader2.load();
                requestControllers.add((RequestController) fxmlLoader2.getController()) ;
                requestControllers.get(i).setData((profile_data) profiles.get(i));
                row++;

                this.grid.add(anchorPane, column, row);
                GridPane.setMargin(anchorPane, new Insets(10.0D));

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
