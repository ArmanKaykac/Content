package com.example.contentsharing.controller;

import com.example.contentsharing.entities.Member;
import com.example.contentsharing.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private MemberService memberService;

    @Autowired
    public LoginController(MemberService theMemberService){
        this.memberService = theMemberService;
    }



}
