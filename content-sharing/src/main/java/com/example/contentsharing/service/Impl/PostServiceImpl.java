package com.example.contentsharing.service.Impl;

import com.example.contentsharing.entities.Member;
import com.example.contentsharing.entities.Post;
import com.example.contentsharing.repositories.PostRepository;
import com.example.contentsharing.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl  implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository thePostRepository){
        this.postRepository = thePostRepository;
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(int id) {
        Optional<Post> result = postRepository.findById(id);

        Post thePost = null;

        if(result.isPresent()){
            thePost = result.get();
        }else{
            throw  new RuntimeException("Could not found the post with id: "+id);
        }

        return thePost;
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deleteById(int id) {
    postRepository.deleteById(id);
    }
}
