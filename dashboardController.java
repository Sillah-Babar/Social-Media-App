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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class dashboardController implements Initializable {

    @FXML
    private Button AccountPrivacy;

    @FXML
    private Button AccountSecurity;

    @FXML
    private ScrollPane MenuScroll;

    @FXML
    private Button Newsfeed;

    @FXML
    private Button Search;

    @FXML
    private Button UpdateBio;

    @FXML
    private Button Upload;

    @FXML
    private Button ViewRequests;

    @FXML
    private Label bio;

    @FXML
    private Label connections;

    @FXML
    private Button deleteAccount;

    @FXML
    private GridPane grid;

    @FXML
    private ImageView profilePic;

    @FXML
    private ListView<String> settings;

    @FXML
    private Button updateInterests;

    @FXML
    private Button uploadProfile;
    private Stage primaryStage;

    @FXML
    private Button Signout;

    @FXML
    void HoverHandled(MouseEvent event) {

    }
    ArrayList<dashboardImages> images;
    //loads the image fxmls to the dashboard
    ArrayList<ImageController> imagefxmls;

    private ArrayList<dashboardImages> getData() {
        ArrayList<dashboardImages> p = new ArrayList<dashboardImages>();
        dashboardImages obj = new dashboardImages();

        obj.setImgPath("cherry.png");
        p.add(obj);


        obj =  new dashboardImages();
        obj.setImgPath("banana.png");
        p.add(obj);


        obj =  new dashboardImages();

        obj.setImgPath("download.jpg");
        p.add(obj);


        obj =  new dashboardImages();

        obj.setImgPath("Biryani.jfif");
        p.add(obj);


        obj =  new dashboardImages();
        obj.setImgPath("coconut.png");
        p.add(obj);

        obj =  new dashboardImages();
        obj.setImgPath("grapes.png");
        p.add(obj);


        obj =  new dashboardImages();
        obj.setImgPath("img1.jpg");
        p.add(obj);


        obj =  new dashboardImages();
        obj.setImgPath("img2.jpg");
        p.add(obj);

        return p;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        images=new ArrayList<dashboardImages>();
        imagefxmls=new ArrayList<ImageController>();
        FXMLLoader fxmlLoader = new FXMLLoader();
        File fp= new File("C:\\Users\\silla\\IdeaProjects\\project\\src\\main\\resources\\com\\example\\project\\dashboard_pictures");
        String [] pathnames;
        pathnames= fp.list();
        Profile pf;
        pf=Profile.getInstance();
        connections.setText(Integer.toString(pf.getTotalConnections()));
        for(int i=0 ; i< pathnames.length ; i++)
        {
            System.out.println(pathnames[i]);

            //adding the images to the dashboard
            dashboardImages obj =  new dashboardImages();
            obj.setImgPath(pathnames[i]);
            images.add(obj);
        }


        System.out.println("hello jee");
        bio.setText(pf.getBio());
        connections.setText(Integer.toString(pf.getTotalConnections()));



        int column = 0;
        int row = 1;

        try {
            for(int i = 0; i < images.size(); ++i)
            {
                FXMLLoader fxmlLoader2 = new FXMLLoader();
                fxmlLoader2.setLocation(this.getClass().getResource("image.fxml"));
                AnchorPane anchorPane = null;

                anchorPane = (AnchorPane)fxmlLoader2.load();
                imagefxmls.add((ImageController) fxmlLoader2.getController()) ;
                imagefxmls.get(i).setData((dashboardImages) images.get(i));
                if (column == 2) {
                    column = 0;
                    ++row;
                }

                this.grid.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(10.0D));

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String dash="dashboard";
        String id=Integer.toString(pf.getId());
        dash+=id;
        dash+="/";
        //setting the profile picture
        Image image = new Image(this.getClass().getResourceAsStream(dash+pf.getProfilepic()));
        profilePic.setImage(image);

    }


    public void actionHandled(javafx.event.ActionEvent actionEvent) throws IOException {
        if(actionEvent.getSource()==Upload)
        {
            JavaFXImageFileChooser obj=new JavaFXImageFileChooser();
            obj.start(Upload);
        }
        else if(actionEvent.getSource()==AccountSecurity)
        {
            changeScene("Security.fxml",actionEvent);
        }
        else if(actionEvent.getSource()==UpdateBio)
        {
            changeScene("UpdateBio.fxml",actionEvent);
        }
        else if(actionEvent.getSource()==AccountPrivacy)
        {
            changeScene("ProfileStatus.fxml",actionEvent);
        }
        else if(actionEvent.getSource()==deleteAccount)
        {
            changeScene("DeleteAccount.fxml",actionEvent);
        }
        else if(actionEvent.getSource()==updateInterests)
        {
            changeScene("Interests.fxml",actionEvent);
        }
        else if(actionEvent.getSource()==Signout)
        {
            changeScene("login.fxml",actionEvent);
        }
        else if(actionEvent.getSource()==uploadProfile)
        {
            SaveProfilePic obj=new SaveProfilePic();
            obj.start(uploadProfile);
            Profile pf;
            pf=Profile.getInstance();

        }
        else if(actionEvent.getSource()==Search)
        {
            changeScene("Search.fxml",actionEvent);
        }
        else if(actionEvent.getSource()==ViewRequests)
        {
            changeScene("RequestPage.fxml",actionEvent);
        }
        else if(actionEvent.getSource()==Newsfeed)
        {
            changeScene("Newsfeed.fxml",actionEvent);
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

