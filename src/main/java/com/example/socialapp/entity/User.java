package com.example.socialapp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
@Data
public class User {
    @Id
    private Long id;

    private String userName;
    private String fullName;
    private String password;


}
