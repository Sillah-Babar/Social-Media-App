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

public class SearchController implements Initializable {

    @FXML
    private ScrollPane MenuScroll;

    @FXML
    private GridPane grid;

    @FXML
    private ImageView profilePic;

    @FXML
    private Button returnbutton;

    @FXML
    private ListView<String> settings;
    private Stage primaryStage;

    ArrayList<search_imageController> searchImagesController;
    ArrayList<profile_data> profiles;
    Profile pf;

    public void sendRequest()
    {
        for(int i=0 ; i<searchImagesController.size() ;i++)
        {
            System.out.println(searchImagesController.get(i).getSendre());
            if(searchImagesController.get(i).getSendre()==1)
            {
                pf.getRequests().add(profiles.get(i).getId());
                searchImagesController.remove(i);
                grid.getChildren().remove(i);
                //profiles.remove(i);
               //searchImagesController.get(i).setSendre(0);

            }
        }
    }
    @FXML
    void actionHandled(ActionEvent event) throws IOException {

        if(event.getSource()==returnbutton)
        {
          changeScene("Menu.fxml",event);
        }

    }

    @FXML
    void HoverHandled(MouseEvent event) {
        sendRequest();
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
    //helper function to test code
    public void addProfiles(Profile pf)
    {
        Database db;
        db=Database.getInstance();
        profiles=db.getConnectionIDS(pf);
       // System.out.println(profiles.size());

/*
        searchProfiles obj=new searchProfiles();
        obj.setUsername("sillah");
        obj.setBio("Adios");
        obj.setProfilePicPath("1profile_pic.png");
        obj.setInterest("Fitness");
        pr.add(obj);


         obj=new searchProfiles();
        obj.setUsername("Shanzay");
        obj.setBio("La Vista");
        obj.setProfilePicPath("2profile_pic.png");
        obj.setInterest("Makeup");
        pr.add(obj);


        obj=new searchProfiles();
        obj.setUsername("Shanzay");
        obj.setBio("Pakistan");
        obj.setProfilePicPath("3profile_pic.png");
        obj.setInterest("music");
        pr.add(obj);


         obj=new searchProfiles();
        obj.setUsername("usman");
        obj.setBio("haha");
        obj.setProfilePicPath("4profile_pic.png");
        obj.setInterest("Sports");
        pr.add(obj);


        obj=new searchProfiles();
        obj.setUsername("safa");
        obj.setBio("yeap");
        obj.setProfilePicPath("5profile_pic.png");
        obj.setInterest("theatre");
        pr.add(obj);
        */

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      profiles=new ArrayList<profile_data>();
      searchImagesController=new ArrayList<search_imageController>();
      pf=Profile.getInstance();
      System.out.println(pf.getId());
      addProfiles(pf);


        int column = 0;
        int row = 1;

        try {
            for(int i = 0; i < profiles.size(); ++i)
            {
                for(int j=0 ; j<profiles.get(i).getInterests().size() ;j++)
                {
                    String Interest=profiles.get(i).getInterests().get(j);

                    System.out.println(Interest);
                    System.out.println(profiles.get(i).getUsername());
                    FXMLLoader fxmlLoader2 = new FXMLLoader();
                    fxmlLoader2.setLocation(this.getClass().getResource("search_image.fxml"));
                    AnchorPane anchorPane = null;

                    anchorPane = (AnchorPane) fxmlLoader2.load();
                    searchImagesController.add((search_imageController) fxmlLoader2.getController());
                    Integer size=searchImagesController.size()-1;
                    searchImagesController.get(size).setData(profiles.get(i),profiles.get(i).getInterests().get(j));
                    row++;

                    this.grid.add(anchorPane, column, row);
                    GridPane.setMargin(anchorPane, new Insets(10.0D));
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
