package com.example.construction_company_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String projects;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getProjects(), that.getProjects());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProjects());
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", projects='" + projects + '\'' +
                '}';
    }
}
