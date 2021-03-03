package com.example.contentsharing.service.Impl;

import com.example.contentsharing.entities.Member;
import com.example.contentsharing.repositories.MemberRepository;
import com.example.contentsharing.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Autowired
    MemberServiceImpl(MemberRepository theMemberRepository){
        this.memberRepository = theMemberRepository;
    }


    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member findById(int id) {
        Optional<Member> result = memberRepository.findById(id);

        Member theMember = null;

        if(result.isPresent()){
            theMember = result.get();
        }else{
            throw  new RuntimeException("Could not found the member with id: "+id);
        }

        return theMember;
    }

    @Override
    public void save(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void deleteById(int id) {
        memberRepository.deleteById(id);

    }

    @Override
    public Member findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }
}
