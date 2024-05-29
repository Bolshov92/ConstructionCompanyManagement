package com.example.construction_company_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

/**
 * Entity class representing a material used in construction projects.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "material")

public class Material {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "quantity_in_stock")
    private int quantityInStock;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Material material)) return false;
        return getQuantityInStock() == material.getQuantityInStock() && Objects.equals(getId(), material.getId()) && Objects.equals(getName(), material.getName()) && Objects.equals(getType(), material.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getType(), getQuantityInStock());
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", quantityInStock=" + quantityInStock +
                '}';
    }
}
