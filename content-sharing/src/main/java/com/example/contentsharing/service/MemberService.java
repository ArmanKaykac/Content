package com.example.contentsharing.service;

import com.example.contentsharing.entities.Member;

import java.util.List;

public interface MemberService {

    public List<Member> findAll();
    public Member findById(int id);
    public void save(Member movie);
    public void deleteById(int id);
    public Member findByUsername(String name);
}
