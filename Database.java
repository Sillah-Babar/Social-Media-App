package com.example.project;

import java.util.ArrayList;

public class Database
{
    ArrayList<profile_data> profiles;
    static Database database;
    int num=1;

    Database()
    {
        profiles=new ArrayList<profile_data>();
    }
    public static Database getInstance()
    {
        if(database==null)
        {

            database=new Database();
            database.num=1;
            database.addProfiles(database.profiles);
        }
        return database;
    }
    public void add(profile_data pf)
    {
        pf.setId(num);
      profiles.add(pf);
      num++;

    }

    public void setProfiles(ArrayList<profile_data> profiles) {
        this.profiles = profiles;
    }

    public ArrayList<profile_data> getProfiles() {
        return profiles;
    }
    public profile_data SearchProfile(String username,String pass)
    {
        for(int i=0 ; i<profiles.size() ;i++)
        {
            if(profiles.get(i).getUsername().equals(username) && profiles.get(i).getPasswr().equals(pass))
            {
                return profiles.get(i);
            }
        }
        return null;
    }
    public Integer getIndex(profile_data pr)
    {
        for(int i=0 ; i<profiles.size() ;i++)
        {
            if(profiles.get(i)==pr)
                return i;

        }
        return -1;
    }
    //returns the arraylist of connections to a particular connection
    public ArrayList<profile_data> getConnectionIDS(Profile pf)
    {
        ArrayList<profile_data> connects=new ArrayList<profile_data>();
        Integer id=pf.getId();


            for(int k=0 ; k<profiles.size() ;k++)
            {
                for(int s=0 ; s<profiles.get(k).getInterests().size() ; s++)
                {
                    if (profiles.get(k).id != id )
                    {
                        connects.add(profiles.get(k));

                    }
                }
            }

        return connects;
    }

    //returns the arraylist of connections to a particular connection
    public ArrayList<profile_data> getRequests(Profile pf)
    {
        ArrayList<profile_data> reqs=new ArrayList<profile_data>();
        //Integer id=pf.getId();


        for(int k=0 ; k<pf.getRequests().size() ;k++)
        {
            for(int s=0 ; s<profiles.size() ; s++)
            {
                if (pf.getRequests().get(k)==profiles.get(s).id )
                {
                    reqs.add(profiles.get(s));

                }
            }
        }

        return reqs;
    }

    public void addProfiles(ArrayList<profile_data> pr)
    {
        profile_data obj=new profile_data();
        obj.setId(1);
        obj.setProfilepic("1profile_pic.png");
        obj.setUsername("sillah");
        obj.setPasswr("babar");
        obj.setBio("Adios");
        obj.setPublic_profile(true);
        //obj.setProfilepic("1profile_pic.png");
        obj.getInterests().add("Fitness");
        obj.getInterests().add("Makeup");

        pr.add(obj);


        obj=new profile_data();
        obj.setId(2);
        obj.setProfilepic("2profile_pic.png");
        obj.setUsername("Shanzay Dhanza");
        obj.setPasswr("Asad");
        obj.setBio("La Vista");
        //obj.setProfilepic("2profile_pic.png");
        obj.getInterests().add("Sports");
        obj.getInterests().add("CS");
        pr.add(obj);


        obj=new profile_data();
        obj.setId(3);
        obj.setProfilepic("3profile_pic.png");
        obj.setUsername("Eysha");
        obj.setPasswr("Fatima");
        obj.setBio("Pakistan");
        //obj.setProfilepic("3profile_pic.png");
        obj.getInterests().add("Gaming");
        obj.getInterests().add("Makeup");
        pr.add(obj);


        obj=new profile_data();
        obj.setId(4);
        obj.setProfilepic("4profile_pic.png");
        obj.setUsername("Usman");
        obj.setPasswr("Shafique");
        obj.setBio("haha");
        // obj.setProfilepic("4profile_pic.png");
        obj.getInterests().add("Fitness");
        obj.getInterests().add("Makeup");
        pr.add(obj);


        obj=new profile_data();
        obj.setId(5);
        obj.setProfilepic("5profile_pic.png");
        obj.setUsername("safa");
        obj.setPasswr("Zaid");
        obj.setBio("yeap");
        //obj.setProfilepic("5profile_pic.png");
        obj.getInterests().add("theatre");
       obj.getInterests().add("Makeup");
       //System.out.println(obj.getInterests().size());
        pr.add(obj);

    }
}
