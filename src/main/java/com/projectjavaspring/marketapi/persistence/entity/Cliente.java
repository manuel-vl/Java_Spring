package com.projectjavaspring.marketapi.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name="CLIENTS")
public class Cliente {
    @Id
    private String id;

    private String name;

    private String surnames;

    private Double cellphone;

    private String address;

    private String email;

    // Relacion Uno a Muchos
    @OneToMany(mappedBy = "cliente")
    private Set<Compra> compras;
}
