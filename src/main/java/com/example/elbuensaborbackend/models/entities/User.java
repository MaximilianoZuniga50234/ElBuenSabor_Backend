package com.example.elbuensaborbackend.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends Base {

    @Column(name = "user")
    private String user;

    @Column(name = "password")
    private String password;

    @Column(name = "profile_pic_url")
    private String profilePictureUrl;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id")
    private Role role;

}
