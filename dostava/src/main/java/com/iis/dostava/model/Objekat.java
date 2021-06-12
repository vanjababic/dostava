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

    @JsonIgnore
    @OneToMany(mappedBy = "objekat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Kuvar> kuvari = new HashSet<Kuvar>();

    @Column
    private String naziv;

    @Column
    private String adresa;



    public Objekat() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Narudzbina> getNarudzbine() {
        return narudzbine;
    }

    public void setNarudzbine(Set<Narudzbina> narudzbine) {
        this.narudzbine = narudzbine;
    }

    public Set<Kuvar> getKuvari() {
        return kuvari;
    }

    public void setKuvari(Set<Kuvar> kuvari) {
        this.kuvari = kuvari;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
