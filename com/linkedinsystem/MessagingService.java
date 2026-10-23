package com.linkedinsystem;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class MessagingService {
    private Map<String,List<Message>> inbox;
    private Map<String,List<Message>> sentMessages;

    public MessagingService() {
        this.inbox = new ConcurrentHashMap<>();
        this.sentMessages = new ConcurrentHashMap<>();
    }

    public void sendMessage(Message message){
        inbox.computeIfAbsent(message.getReceiver().getId(),k->new CopyOnWriteArrayList<>()).add(message);
        sentMessages.computeIfAbsent(message.getSender().getId(),k->new CopyOnWriteArrayList<>()).add(message);
    }

    public List<Message> getInbox(Member member){
        return inbox.getOrDefault(member.getId(),Collections.emptyList());
    }

    public List<Message> getSentMessages(Member member){
        return sentMessages.getOrDefault(member.getId(),Collections.emptyList());
    }

}
