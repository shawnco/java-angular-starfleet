package com.example.demo.starship;

import javax.persistence.*;

@Entity
@Table
public class Starship {
    @Id
    @SequenceGenerator(
            name = "starship_sequence",
            sequenceName = "starship_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "starship_sequence"
    )
    private int id;
    private String name;
    private String registry;

    @Transient
    private String registryA;

    public int getId(){ return id; }
    public String getName(){ return name; }
    public String getRegistry(){ return registry; }
    public String getRegistryA() { return this.registry + "-A"; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name=name; }
    public void setRegistry(String registry) { this.registry=registry; }
    public void setRegistryA(String registry) { this.registryA = registry + "-A"; }

    public Starship() {}

    public Starship(int id, String name, String registry) {
        this.id = id;
        this.name = name;
        this.registry = registry;
    }

    public Starship(String name, String registry) {
        this.name = name;
        this.registry = registry;
    }
}