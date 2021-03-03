package com.example.contentsharing.repositories;

import com.example.contentsharing.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findByUsername(String username);
}
