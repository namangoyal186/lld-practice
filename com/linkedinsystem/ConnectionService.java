package com.linkedinsystem;
import java.util.*;

import java.util.concurrent.ConcurrentHashMap;

public class ConnectionService {
    Map<String,Connection> connections = new ConcurrentHashMap<>();

    private NotificationService notificationService;

    public ConnectionService(NotificationService notificationService){
        this.notificationService=notificationService;
    }

    public void sendRequest(Member memberFrom, Member memberTo){
        String key = memberFrom.getId()+"_"+memberTo.getId();
        Connection connection = new Connection(memberFrom,memberTo);
        connections.put(key,connection);

        Notification notification = new Notification(UUID.randomUUID().toString(),NotificationType.CONNECTION_REQUEST,memberTo,memberFrom.getName()+" sent you a connection request");
        notificationService.sendNotification(memberTo,notification);

    }

    public void acceptRequest(Member receiver, Member sender){
        String key = sender.getId()+"_"+receiver.getId();
        Connection connection = connections.get(key);

        if(connection==null){
            throw new IllegalArgumentException("Connection request not found");
        }
        connection.accept();
        sender.addConnection(receiver);
        receiver.addConnection(sender);

        Notification notification = new Notification(UUID.randomUUID().toString(),NotificationType.CONNECTION_REQUEST, sender,receiver.getName()+" Accepted your connection request");

        notificationService.sendNotification(sender,notification);
    }

    public void rejectRequest(Member receiver, Member sender){
        String key = sender.getId()+"_"+receiver.getId();
        Connection connection = connections.get(key);
        if(connection!=null){
            connection.reject();
        }
    }

    public List<Member> getConnections(Member member){
        return member.getConnections();
    }




}
