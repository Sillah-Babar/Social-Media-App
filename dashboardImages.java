package com.example.project;

public class dashboardImages {
    private String imagepath;
    public dashboardImages(String im)
    {
        imagepath=im;
    }
    public dashboardImages()
    {
        imagepath="";
    }
    public String getImgPath()
    {
        return  imagepath;
    }
    public void setImgPath(String im)
    {
        imagepath=im;
    }
}
