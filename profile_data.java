package com.example.project;

import java.util.ArrayList;

public class profile_data {
    Integer id;
    String username;
    String passwr;
    boolean  public_profile;
    boolean deleteAccount;
    String profilepic;
    ArrayList<String> interests;
    ArrayList<String> images;

    ArrayList<Integer> connections;
    String bio;
    ArrayList<Integer> requests;
    ArrayList<String> dashboardpics;

    public void setRequests(ArrayList<Integer> requests) {
        this.requests = requests;
    }

    public ArrayList<Integer> getRequests() {
        return requests;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public profile_data()
    {
        id=0;
        requests=new ArrayList<Integer>();
        interests=new ArrayList<String>();
        images=new ArrayList<String>();
        connections=new ArrayList<Integer>();
        username="";
        passwr="";
        public_profile=false;
        profilepic="profile_pic.png";

        deleteAccount=false;
        bio="";
        dashboardpics=new ArrayList<String>();
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    public void setDashboardpics(ArrayList<String> dashboardpics) {
        this.dashboardpics = dashboardpics;
    }

    public ArrayList<String> getDashboardpics() {
        return dashboardpics;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswr(String passwr) {
        this.passwr = passwr;
    }

    public void setPublic_profile(boolean public_profile) {
        this.public_profile = public_profile;
    }

    public void setDeleteAccount(boolean deleteAccount) {
        this.deleteAccount = deleteAccount;
    }

    public boolean isDeleteAccount() {
        return deleteAccount;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public void setInterests(ArrayList<String> interests) {
        this.interests = interests;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public void setConnections(ArrayList<Integer> connections) {
        this.connections = connections;
    }

    public String getPasswr() {
        return passwr;
    }

    public boolean isPublic_profile() {
        return public_profile;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public ArrayList<String> getInterests() {
        return interests;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public ArrayList<Integer> getConnections() {
        return connections;
    }
    public Integer getTotalConnections()
    {
        return connections.size();
    }
}
