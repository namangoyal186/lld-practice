package com.linkedinsystem;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AuthenticationService {
    private Map<String,Member> members = new ConcurrentHashMap<>();

    private Map<String,Member> activeSessions = new ConcurrentHashMap<>();

    public void register(Member member) {
        System.out.println("REGISTER called");
        System.out.println("Registering email: " + member.getEmail());

        members.put(member.getEmail(), member);

        System.out.println("Members count after registration: "
                + members.size());
    }

    public String login(String email, String password) {
        Member member = members.get(email);

        System.out.println("Email received: " + email);
        System.out.println("Member found: " + (member != null));

        if (member != null) {
            System.out.println("Stored password: " + member.getPassword());
            System.out.println("Entered password: " + password);
        }

        if (member == null ||
                !member.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        String token = UUID.randomUUID().toString();
        activeSessions.put(token, member);
        return token;
    }

    public void logout(String token){
        activeSessions.remove(token);
    }

    public Member getUserFromToken(String token){
        return activeSessions.get(token);
    }
}
