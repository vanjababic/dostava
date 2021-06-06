package com.iis.dostava.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Narudzbina {

    @Id
    @SequenceGenerator(name="seq_narudzbina", sequenceName = "seq_narudzbina", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_narudzbina")
    private Integer id;

    @Column
    private Double ukupnaCena;

    @Column
    private LocalDate datum;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Kupac kupac;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Objekat objekat;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "statusNarudzbine_id", referencedColumnName = "id")
    private StatusNarudzbine statusNarudzbine;

    @OneToMany(mappedBy = "narudzbina", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<NarudzbinaProizvodi> narudzbineProizvodi = new HashSet<NarudzbinaProizvodi>();

    public Narudzbina() {
    }


}
