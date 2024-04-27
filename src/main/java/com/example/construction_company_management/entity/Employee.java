package com.example.construction_company_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")

    private String lastName;
    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "age")
    private int age;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "supervision")
    private Employee superWiser;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return getAge() == employee.getAge() && Objects.equals(getId(), employee.getId()) && Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName()) && Objects.equals(getContactInfo(), employee.getContactInfo()) && Objects.equals(getHireDate(), employee.getHireDate()) && Objects.equals(getEndDate(), employee.getEndDate()) && Objects.equals(getDepartment(), employee.getDepartment()) && Objects.equals(getSuperWiser(), employee.getSuperWiser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getContactInfo(), getAge(), getHireDate(), getEndDate(), getDepartment(), getSuperWiser());
    }
}
