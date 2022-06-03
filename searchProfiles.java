package com.example.project;

import javafx.scene.image.Image;

public class searchProfiles {
    String profilePicPath;
    Image profilePic;
    Integer id;
    String interest;
    String bio;
    String username;
    public searchProfiles()
    {
        profilePicPath="";
        profilePic=null;
        id=0;
        interest="";
        bio="";
        username="";

    }

    public void setProfilePicPath(String profilePicPath) {
        this.profilePicPath = profilePicPath;
    }

    public void setProfilePic(Image profilePic) {
        this.profilePic = profilePic;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePicPath() {
        return profilePicPath;
    }

    public Image getProfilePic() {
        return profilePic;
    }

    public Integer getId() {
        return id;
    }

    public String getInterest() {
        return interest;
    }

    public String getBio() {
        return bio;
    }

    public String getUsername() {
        return username;
    }
}
