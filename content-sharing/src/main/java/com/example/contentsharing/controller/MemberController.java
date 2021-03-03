package com.example.contentsharing.controller;


import com.example.contentsharing.entities.Member;
import com.example.contentsharing.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600L, allowedHeaders = "*")
@RestController
@RequestMapping("/member")
public class MemberController {
    private MemberService memberService;


    public MemberController(MemberService theMemberService){
        this.memberService = theMemberService;
    }


    @GetMapping("/list")
    public ResponseEntity<List<Member>> showAll(){
        return new ResponseEntity<>(memberService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/login")
    public ResponseEntity<Member> login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password){

        Member member = memberService.findByUsername(username);
        String pass =member.getPassword();
        if(pass.equals(password)){
            return new ResponseEntity<>(member, HttpStatus.OK);
        }else {
            System.out.println(pass);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getUserById(@PathVariable int id){
        return new ResponseEntity<>(memberService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(value =  "/delete/{id}")
    public void deleteMember(@PathVariable int id){
        memberService.deleteById(id);
    }



}
