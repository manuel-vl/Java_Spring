package com.projectjavaspring.marketapi.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

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

}
