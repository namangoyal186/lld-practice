package com.linkedinsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ChronologicalSortStrategy implements FeedSortingStrategy{
    @Override
    public List<Post> sort(List<Post> posts) {
        List<Post> sortedPosts = new ArrayList<>(posts);
        sortedPosts.sort(Comparator.comparing(Post::getCreatedAt).reversed());
        return sortedPosts;
    }
}
