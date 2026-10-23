package com.linkedinsystem;
import java.util.*;

import java.util.concurrent.CopyOnWriteArrayList;

public class NewsFeedService {
    List<Post> allPosts = new CopyOnWriteArrayList<>();

    private FeedSortingStrategy feedSortingStrategy;

    public NewsFeedService(FeedSortingStrategy feedSortingStrategy){
        this.feedSortingStrategy=feedSortingStrategy;
    }

    public void addPost(Post post){
        allPosts.add(post);
    }

    public List<Post> getFeed(Member member){
        return feedSortingStrategy.sort(allPosts);
    }

    public void setFeedSortingStrategy(FeedSortingStrategy feedSortingStrategy){
        this.feedSortingStrategy=feedSortingStrategy;
    }


}
