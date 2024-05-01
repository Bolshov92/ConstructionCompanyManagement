package com.example.construction_company_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "authority")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid_generator")
    @GenericGenerator(name = "uuid_generator", strategy = "com.example.construction_company_management.uuidGenerator.UuidTimeSequenceGenerator")
    @Column(name = "id")
    private UUID authorityId;

    @Column(name = "authority")
    private String authorityName;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}