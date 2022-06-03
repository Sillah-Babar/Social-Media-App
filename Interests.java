package com.example.project;

import java.util.ArrayList;

public class Interests {
    ArrayList<String> interests;
    static Interests obj;
    private Interests()
    {
        obj=null;
        interests=new ArrayList<>();
    }

    public static Interests getInstance()
    {
        if(obj==null)
        {
            obj=new Interests();
        }
        return obj;

    }
    public void setInterests(ArrayList<String> interests) {
        this.interests = interests;
    }

    public ArrayList<String> getInterests() {
        return interests;
    }
    public void addInterests()
    {
        Interests pf;
        pf=Interests.getInstance();
        pf.getInterests().add("Fitness");
        pf.getInterests().add("Computer Science");
        pf.getInterests().add("studying");
        pf.getInterests().add("sports");
        pf.getInterests().add("theatre");
        pf.getInterests().add("music");
        pf.getInterests().add("makeup");
        pf.getInterests().add("gaming");
        pf.getInterests().add("astrology");


    }
}
