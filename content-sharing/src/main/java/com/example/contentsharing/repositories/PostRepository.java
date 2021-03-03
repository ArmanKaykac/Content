package com.example.contentsharing.repositories;

import com.example.contentsharing.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface PostRepository  extends JpaRepository<Post, Integer> {
}
