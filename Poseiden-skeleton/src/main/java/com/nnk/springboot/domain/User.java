package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Integer id;
    
    @NotBlank(message = "Username is mandatory")
    @Column
    private String username;
    
    @NotBlank(message = "Password is mandatory")
    @Column
    @Pattern(regexp="^(?=.{8,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).*$",
    message="Password should have at least 1 letter min, 1 letter maj, 1 number, 8 characters and a special character . ")
    private String password;
    
    @NotBlank(message = "FullName is mandatory")
    @Column
    private String fullname;
    
    @Column
    private String role;

    
}
