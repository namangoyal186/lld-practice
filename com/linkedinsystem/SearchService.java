package com.linkedinsystem;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SearchService {
    private Map<String,Member> members = new ConcurrentHashMap<>();

    public void addMember(Member member){
        members.put(member.getId(),member);
    }

    public List<Member> getAllMembers(){
        return new ArrayList<>(members.values());
    }

    public List<Member> searchByName(String name){
        List<Member> result = new ArrayList<>();
        for(Member member:members.values()){
            if(member.getName().toLowerCase().equals(name.toLowerCase())){
                result.add(member);
            }
        }
        return result;
    }
}
