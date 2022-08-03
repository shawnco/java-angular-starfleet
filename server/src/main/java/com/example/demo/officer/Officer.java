package com.example.demo.officer;

import javax.persistence.*;

@Entity
@Table
public class Officer {
    @Id
    @SequenceGenerator(
            name = "officer_sequence",
            sequenceName = "officer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "officer_sequence"
    )
    private int id;
    private String name;
    private String officerRank;

    public int getId() { return id; }
    public String getName() { return name; }
    public String getRank() { return officerRank; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setRank(String rank) { this.officerRank = rank; }

    public Officer() {}

    public Officer(int id, String name, String officerRank) {
        this.id = id;
        this.name = name;
        this.officerRank = officerRank;
    }

    public Officer(String name, String officerRank) {
        this.name = name;
        this.officerRank = officerRank;
    }
}
