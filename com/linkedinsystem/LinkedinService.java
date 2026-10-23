package com.linkedinsystem;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LinkedinService {
    private static LinkedinService linkedinServiceInstance;

    Map<String,Member> members = new ConcurrentHashMap<>();

    private AuthenticationService authenticationService;
    private NotificationService notificationService;
    private ConnectionService connectionService;
    private MessagingService messagingService;
    private JobService jobService;
    private SearchService searchService;
    private NewsFeedService newsFeedService;

    private LinkedinService() {
        this.authenticationService = new AuthenticationService();
        this.notificationService = new NotificationService();
        this.connectionService = new ConnectionService(notificationService);
        this.messagingService = new MessagingService();
        this.jobService = new JobService();
        this.searchService = new SearchService();
        this.newsFeedService = new NewsFeedService(new ChronologicalSortStrategy());
    }

    public static synchronized LinkedinService getInstance(){
        if(linkedinServiceInstance==null){
            synchronized (LinkedinService.class){
                if(linkedinServiceInstance==null){
                    linkedinServiceInstance=new LinkedinService();
                }
            }
        }
        return linkedinServiceInstance;
    }

    // ---------------- REGISTER ----------------
    public Member register(String name,String email,String password){
        String id = UUID.randomUUID().toString();

        Member member=new Member(id,name,email,password);

        authenticationService.register(member);

        members.put(id,member);

        searchService.addMember(member);

        return member;
    }

    // ---------------- LOGIN ----------------

    public String login(String email, String password){
        return authenticationService.login(email,password);
    }

    // ---------------- LOGOUT ----------------

    public void logout(String token){
        authenticationService.logout(token);
    }

    // ---------------- CONNECTION ----------------

    public void sendConnectionRequest(Member from, Member to){
        connectionService.sendRequest(from,to);
    }

    public void acceptConnectionRequest(Member receiver, Member sender){
        connectionService.acceptRequest(receiver,sender);
    }

    public void rejectConnectionRequest(Member receiver, Member sender){
        connectionService.rejectRequest(receiver,sender);
    }

    public List<Member> getConnections(Member member){
        return connectionService.getConnections(member);
    }

    // ---------------- MESSAGING ----------------

    public void sendMessage(Member sender, Member receiver, String content){
        Message message = new Message(UUID.randomUUID().toString(),sender,receiver,content);
        messagingService.sendMessage(message);
        Notification notification=new Notification(UUID.randomUUID().toString(),NotificationType.MESSAGE,receiver,"New message from " + sender.getName());
        notificationService.sendNotification(receiver,notification);
    }

    public List<Message> getInbox(Member member){
        return messagingService.getInbox(member);
    }

    // ---------------- JOBS ----------------

    public void postJob(JobPosting job){
        jobService.postJob(job);
    }

    public List<JobPosting> searchJobs(String keyword){
        return jobService.searchJobs(keyword);
    }

    // ---------------- SEARCH ----------------

    public List<Member> searchMembers(String name){
        return searchService.searchByName(name);
    }

    // ---------------- POSTS ----------------

    public void createPost(Post post){
        newsFeedService.addPost(post);
    }

    public List<Post> getFeed(Member member){
        return newsFeedService.getFeed(member);
    }


}
