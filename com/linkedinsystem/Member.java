package com.linkedinsystem;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Member {
    private Profile profile;
    private String name;
    private String email;
    private String id;
    private String password;

    private List<Notification> notificationList;
    private List<Member> connections;

    public Member(String id, String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.profile = new Profile();
        this.password = password;
        this.notificationList = new CopyOnWriteArrayList<>();
        this.connections = new CopyOnWriteArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Profile getProfile() {
        return profile;
    }

    public List<Member> getConnections() {
        return connections;
    }

    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void addConnection(Member member){
        connections.add(member);
    }

    public void addNotification(Notification notification){
        notificationList.add(notification);
    }

    public void viewNotifications(){
        for(Notification notification:notificationList){
            System.out.println(notification);
        }
    }

    public void updateProfile(Profile profile){
        this.profile=profile;
    }

    public void displayProfile() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        profile.display();
    }
}
