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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NewsfeedController implements Initializable {

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
    ArrayList<NewsfeedImageController> newsimageController;
    ArrayList<profile_data> profiles;
    private Stage primaryStage;

    @FXML
    void HoverHandled(MouseEvent event) {


    }
    //helper function to test code
    public void addProfiles(ArrayList<profile_data> pr)
    {
        profile_data obj=new profile_data();
        obj.setId(1);
        obj.setUsername("sillah");
        obj.setBio("Adios");
        obj.setPublic_profile(true);
        obj.setProfilepic("1profile_pic.png");
        obj.getInterests().add("Fitness");
        obj.getInterests().add("Makeup");
        File fp= new File("C:\\Users\\silla\\IdeaProjects\\project\\src\\main\\resources\\com\\example\\project\\dashboard1");
        String [] pathnames;
        pathnames= fp.list();
        ArrayList<String> p=new ArrayList<String>();
        for(int i=0 ; i< pathnames.length ;i++)
        {
            p.add(pathnames[i]);
        }
        obj.setDashboardpics(p);

        pr.add(obj);


        obj=new profile_data();
        obj.setId(2);
        obj.setUsername("Shanzay");
        obj.setBio("La Vista");
        obj.setProfilepic("2profile_pic.png");
        obj.getInterests().add("Sports");
        obj.getInterests().add("Makeup");
        fp= new File("C:\\Users\\silla\\IdeaProjects\\project\\src\\main\\resources\\com\\example\\project\\dashboard2");
        String [] pathnames2;
        pathnames2= fp.list();
        p=new ArrayList<String>();
        for(int i=0 ; i< pathnames2.length ;i++)
        {
            p.add(pathnames2[i]);
        }
        obj.setDashboardpics(p);
        pr.add(obj);


        obj=new profile_data();
        obj.setId(3);
        obj.setUsername("Shanzay");
        obj.setBio("Pakistan");
        obj.setProfilepic("3profile_pic.png");
        obj.getInterests().add("Gaming");
        obj.getInterests().add("Makeup");
        fp= new File("C:\\Users\\silla\\IdeaProjects\\project\\src\\main\\resources\\com\\example\\project\\dashboard3");
        String [] pathnames1;
        pathnames1= fp.list();
        p=new ArrayList<String>();
        for(int i=0 ; i< pathnames1.length ;i++)
        {
            p.add(pathnames1[i]);
        }
        obj.setDashboardpics(p);
        pr.add(obj);


        obj=new profile_data();
        obj.setId(4);
        obj.setUsername("usman");
        obj.setBio("haha");
        obj.setProfilepic("4profile_pic.png");
        obj.getInterests().add("Fitness");
        obj.getInterests().add("Makeup");
        fp= new File("C:\\Users\\silla\\IdeaProjects\\project\\src\\main\\resources\\com\\example\\project\\dashboard3");
        String [] pathnames3;
        pathnames3= fp.list();
        p=new ArrayList<String>();
        for(int i=0 ; i< pathnames3.length ;i++)
        {
            p.add(pathnames3[i]);
        }
        obj.setDashboardpics(p);
        pr.add(obj);


        obj=new profile_data();
        obj.setId(5);
        obj.setUsername("safa");
        obj.setBio("yeap");
        obj.setProfilepic("5profile_pic.png");
        obj.getInterests().add("theatre");
        obj.getInterests().add("Makeup");
        fp= new File("C:\\Users\\silla\\IdeaProjects\\project\\src\\main\\resources\\com\\example\\project\\dashboard4");
        String [] pathnames4;
        pathnames4= fp.list();
        p=new ArrayList<String>();
        for(int i=0 ; i< pathnames4.length ;i++)
        {
            p.add(pathnames4[i]);
        }
        obj.setDashboardpics(p);
        pr.add(obj);

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
        newsimageController=new ArrayList<NewsfeedImageController>();
        addProfiles(profiles);


        int column = 0;
        int row = 1;

        try {
            for(int i = 0; i < profiles.size(); ++i)
            {
                FXMLLoader fxmlLoader2 = new FXMLLoader();
                fxmlLoader2.setLocation(this.getClass().getResource("NewsfeedImage.fxml"));
                AnchorPane anchorPane = null;

                anchorPane = (AnchorPane)fxmlLoader2.load();
                newsimageController.add((NewsfeedImageController) fxmlLoader2.getController()) ;
                newsimageController.get(i).setData((profile_data) profiles.get(i));
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
