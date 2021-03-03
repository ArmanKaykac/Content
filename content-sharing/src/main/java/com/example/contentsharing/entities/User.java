package com.example.contentsharing.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


import java.util.List;

@Entity
@DiscriminatorValue("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends Member {




    @ManyToOne
    @JoinColumn(name = "admin_id")
    @JsonIgnore
    private Admin admin;
}
