package com.mycompany.property_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="USER_TABLE")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name ="OWNER_NAME", nullable = false)
    private String ownerName;
    @Column(name ="EMAIL", nullable = false)
    private String ownerEmail;
    private String phone;
    private String password;
}
