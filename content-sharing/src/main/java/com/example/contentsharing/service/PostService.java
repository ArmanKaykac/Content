package com.example.contentsharing.service;

import com.example.contentsharing.entities.Post;

import java.util.List;

public interface PostService {
    public List<Post> findAll();
    public Post findById(int id);
    public void save(Post post);
    public void deleteById(int id);
}
