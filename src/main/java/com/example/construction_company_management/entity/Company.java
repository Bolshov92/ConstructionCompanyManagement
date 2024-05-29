package com.example.construction_company_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * Entity class representing a construction company.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "company")
public class Company {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = " turnover")
    private double turnover;

    @Column(name = "expenses")
    private double expenses;

    @Column(name = "profit")
    private double profit;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL) // сompany can have many projects
    private Set<ConstructionProject> projects;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company company)) return false;
        return Double.compare(getTurnover(), company.getTurnover()) == 0 && Double.compare(getExpenses(), company.getExpenses()) == 0 && Double.compare(getProfit(), company.getProfit()) == 0 && Objects.equals(getId(), company.getId()) && Objects.equals(getName(), company.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getTurnover(), getExpenses(), getProfit());
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", turnover=" + turnover +
                ", expenses=" + expenses +
                ", profit=" + profit +
                '}';
    }
}
