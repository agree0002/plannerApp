package com.igrus.demo.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

/*    @Column(unique = true, nullable = false)*/
    private String username;

/*    @Column(unique = true, nullable = false)*/
    private String email;

/*    @Column(nullable = false)*/
    private String password;

/*    @Column(nullable = false, updatable = false)*/
/*    private LocalDateTime created_at;*/

/*    @PrePersist
    protected void onCreate() {
        this.created_at = LocalDateTime.now();
    }*/
}
