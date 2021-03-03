package com.example.contentsharing.controller;

import com.example.contentsharing.entities.Member;
import com.example.contentsharing.entities.Post;
import com.example.contentsharing.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600L, allowedHeaders = "*")
@RestController
@RequestMapping("/post")
public class PostController {
    private PostService postService;

    public  PostController(PostService thePostService){
        this.postService = thePostService;
    }

    @PostMapping("/create")
    public void createPost(@RequestBody Post post) {
        postService.save(post);
    }
//   create {
//        "id": 3,
//            "title": "title3",
//            "imgUrl": "test3",
//            "description": "description3",
//            "member": {
//                  "id": 1

//    }}
    @GetMapping("/list")
    public ResponseEntity<List<Post>> showAll(){
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> showOne(@PathVariable int id){
        return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(value =  "/delete/{id}")
    public void deleteTask(@PathVariable int id){
        postService.deleteById(id);
    }

}
