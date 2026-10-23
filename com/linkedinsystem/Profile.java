package com.linkedinsystem;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Profile {
    private List<Education> educationList;
    private List<Experience> experienceList;
    private List<String> skills;
    private String summary;
    private String headline;
    private String profilePicture;

    public Profile(){
        experienceList=new CopyOnWriteArrayList<>();
        educationList=new CopyOnWriteArrayList<>();
        skills=new CopyOnWriteArrayList<>();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void addSkill(String skill) {
        skills.add(skill);
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void display() {
        System.out.println("Headline: " + headline);
        System.out.println("Summary: " + summary);

        System.out.println("Skills:");
        for (String skill : skills) {
            System.out.println("- " + skill);
        }

        System.out.println("Experience:");
        for (Experience experience : experienceList) {
            System.out.println(experience);
        }

        System.out.println("Education:");
        for (Education education : educationList) {
            System.out.println(education);
        }
    }


}
