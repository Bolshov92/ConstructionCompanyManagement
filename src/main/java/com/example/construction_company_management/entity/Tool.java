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
@Table(name = "tool")
public class Tool {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "serial_number")
    private int serialNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tool tool)) return false;
        return getSerialNumber() == tool.getSerialNumber() && Objects.equals(getId(), tool.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSerialNumber());
    }

    @Override
    public String toString() {
        return "Tool{" +
                "id=" + id +
                ", serialNumber=" + serialNumber +
                '}';
    }
}
