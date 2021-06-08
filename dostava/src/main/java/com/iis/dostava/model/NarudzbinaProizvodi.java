package com.iis.dostava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class NarudzbinaProizvodi {

    @Id
    @SequenceGenerator(name="seq_narudzbinaProizvodi", sequenceName = "seq_narudzbinaProizvodi", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_narudzbinaProizvodi")
    private Integer id;

    @Column
    private Integer kolicina;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Narudzbina narudzbina;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Proizvod proizvod;

    public NarudzbinaProizvodi() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public Narudzbina getNarudzbina() {
        return narudzbina;
    }

    public void setNarudzbina(Narudzbina narudzbina) {
        this.narudzbina = narudzbina;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }
}
