package com.example.construction_company_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * Entity class representing a construction project.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "construction_project")
public class ConstructionProject {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee projectManager;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConstructionProject that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getProjectName(), that.getProjectName()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getProjectManager(), that.getProjectManager()) && Objects.equals(getStartDate(), that.getStartDate()) && Objects.equals(getEndDate(), that.getEndDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProjectName(), getAddress(), getDescription(), getProjectManager(), getStartDate(), getEndDate());
    }

    @Override
    public String toString() {
        return "ConstructionProject{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", projectManager=" + projectManager +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
