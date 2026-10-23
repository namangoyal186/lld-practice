package com.linkedinsystem;

import java.time.LocalDateTime;

public class Connection {
    private Member fromMember;
    private Member toMember;

    private LocalDateTime requestedAt;
    private LocalDateTime acceptedAt;

    private ConnectionStatus connectionStatus;

    public Connection(Member fromMember, Member toMember) {
        this.fromMember = fromMember;
        this.toMember = toMember;
        this.connectionStatus = ConnectionStatus.PENDING;
        this.requestedAt = LocalDateTime.now();
    }

    public Member getFromMember() {
        return fromMember;
    }

    public void setFromMember(Member fromMember) {
        this.fromMember = fromMember;
    }

    public Member getToMember() {
        return toMember;
    }

    public void setToMember(Member toMember) {
        this.toMember = toMember;
    }

    public ConnectionStatus getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(ConnectionStatus connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public void accept(){
        this.connectionStatus=ConnectionStatus.ACCEPTED;
        this.acceptedAt=LocalDateTime.now();
    }

    public void reject(){
        this.connectionStatus=ConnectionStatus.REJECTED;
    }

    public Member getOtherMember(Member member){
        if(member.getId().equals(fromMember.getId())){
            return toMember;
        }
        return fromMember;
    }
}
