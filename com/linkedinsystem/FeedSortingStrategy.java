package com.linkedinsystem;
import java.util.*;

public interface FeedSortingStrategy {
    public List<Post> sort(List<Post> posts);
}
