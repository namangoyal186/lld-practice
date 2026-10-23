package com.linkedinsystem;
import java.util.*;

public class LinkedInDemo {
    public static void main(String[] args) {

        LinkedinService linkedin =
                LinkedinService.getInstance();

        // ---------------- REGISTER ----------------

        Member naman =
                linkedin.register(
                        "Naman",
                        "naman@gmail.com",
                        "password"
                );

        Member rahul =
                linkedin.register(
                        "Rahul",
                        "rahul@gmail.com",
                        "password"
                );

        // ---------------- LOGIN ----------------

        String token =
                linkedin.login(
                        "naman@gmail.com",
                        "password"
                );

        System.out.println(
                "Logged in. Token = " + token
        );

        // ---------------- PROFILE ----------------

        Profile profile = naman.getProfile();

        profile.setHeadline(
                "Senior Software Developer"
        );

        profile.setSummary(
                "Java Backend Engineer"
        );

        profile.addSkill("Java");
        profile.addSkill("Spring Boot");
        profile.addSkill("Kafka");

        profile.display();

        // ---------------- CONNECTION ----------------

        linkedin.sendConnectionRequest(
                naman,
                rahul
        );

        linkedin.acceptConnectionRequest(
                rahul,
                naman
        );

        System.out.println(
                "Connections of Naman:"
        );

        for (Member member :
                linkedin.getConnections(naman)) {

            System.out.println(member.getName());
        }

        // ---------------- MESSAGE ----------------

        linkedin.sendMessage(
                naman,
                rahul,
                "Hi Rahul, how are you?"
        );

        System.out.println(
                "Rahul Inbox:"
        );

        for (Message message :
                linkedin.getInbox(rahul)) {

            System.out.println(
                    message.getContent()
            );
        }

        // ---------------- JOB ----------------

        JobPosting job =
                new JobPosting(
                        "J1",
                        "Senior Java Developer",
                        "Backend development",
                        Arrays.asList(
                                "Java",
                                "Spring Boot",
                                "Kafka"
                        ),
                        "Gurugram",
                        rahul
                );

        linkedin.postJob(job);

        // ---------------- SEARCH ----------------

        System.out.println(
                "Search Results:"
        );

        for (Member member :
                linkedin.searchMembers("Naman")) {

            System.out.println(
                    member.getName()
            );
        }

        // ---------------- LOGOUT ----------------

        linkedin.logout(token);
    }
}
