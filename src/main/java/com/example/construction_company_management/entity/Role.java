package com.example.construction_company_management.entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid_generator")
    @GenericGenerator(name = "uuid_generator", strategy = "com.example.construction_company_management.uuidGenerator.UuidTimeSequenceGenerator")
    @Column(name = "role_id")
    private UUID roleId;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<Authority> authorities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role role)) return false;
        return Objects.equals(getRoleId(), role.getRoleId()) && Objects.equals(getRoleName(), role.getRoleName()) && Objects.equals(getAuthorities(), role.getAuthorities());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoleId(), getRoleName(), getAuthorities());
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}