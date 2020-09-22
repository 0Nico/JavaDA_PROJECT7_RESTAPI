package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
    private String password;
    
    @NotBlank(message = "FullName is mandatory")
    @Column
    private String fullname;
    
    @NotBlank(message = "Role is mandatory")
    @Column
    private String role;

    
}
