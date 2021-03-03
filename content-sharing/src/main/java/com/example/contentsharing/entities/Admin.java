package com.example.contentsharing.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends Member{




    @OneToMany(mappedBy = "admin")
    private List<User> users;



}
