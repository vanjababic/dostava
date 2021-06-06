package com.iis.dostava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Proizvod {

    @Id
    @SequenceGenerator(name="seq_proizvod", sequenceName = "seq_proizvod", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_proizvod")
    private Integer id;

    @Column
    private String naziv;

    @Column
    private Double cena;

    @OneToMany(mappedBy = "proizvod", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<NarudzbinaProizvodi> narudzbineProizvodi = new HashSet<NarudzbinaProizvodi>();

    public Proizvod() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }
}
