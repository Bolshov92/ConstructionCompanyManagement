package com.example.construction_company_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")

    private String lastName;
    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "age")
    private int age;

    @Column(name = "hireDate")
    private LocalDate hirDate;

    @Column(name = "endDate")
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "supervision")
    private Employee superViser;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return getAge() == employee.getAge() && Objects.equals(getId(), employee.getId()) && Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName()) && Objects.equals(getContactInfo(), employee.getContactInfo()) && Objects.equals(getSuperViser(), employee.getSuperViser()) && Objects.equals(getHirDate(), employee.getHirDate()) && Objects.equals(getEndDate(), employee.getEndDate()) && Objects.equals(getDepartment(), employee.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getContactInfo(), getAge(), getSuperViser(), getHirDate(), getEndDate(), getDepartment());
    }
}
