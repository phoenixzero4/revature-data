package com.revatrure.data.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity // tells Hibernate this is a resource that needs to be mapped to a table in the DB
@Table(name = "owners") // tells ORM the table is different from the class name
public class Owner {
    @Id
    private UUID id;
    private String name;


}
