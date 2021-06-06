package com.iis.dostava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Objekat {

    @Id
    @SequenceGenerator(name="seq_objekat", sequenceName = "seq_objekat", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_objekat")
    private Integer id;

    @JsonIgnore
    @OneToMany(mappedBy = "objekat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Narudzbina> narudzbine = new HashSet<Narudzbina>();

    @Column
    private String name;



}
