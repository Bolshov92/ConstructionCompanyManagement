package com.example.construction_company_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

/**
 * Entity class representing additional user information.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid_generator")
    @GenericGenerator(name = "uuid_generator", strategy = "com.example.construction_company_management.uuidGenerator.UuidTimeSequenceGenerator")
    @Column(name = "id")
    private UUID id;

    @Column(name = "user_name")
    private String userName;

    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private User user;


}