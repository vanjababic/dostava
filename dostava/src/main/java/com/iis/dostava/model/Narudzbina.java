package com.iis.dostava.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
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

    @Column
    private Boolean narucena;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Kupac kupac;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Objekat objekat;

    @JsonIgnore
    @OneToMany(mappedBy = "narudzbina", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Ponuda> ponude = new HashSet<Ponuda>();


    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "statusNarudzbine_id", referencedColumnName = "id")
    private StatusNarudzbine statusNarudzbine;

    @OneToMany(mappedBy = "narudzbina", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<NarudzbinaProizvodi> narudzbineProizvodi = new HashSet<NarudzbinaProizvodi>();

    public Narudzbina() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(Double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public Objekat getObjekat() {
        return objekat;
    }

    public void setObjekat(Objekat objekat) {
        this.objekat = objekat;
    }

    public StatusNarudzbine getStatusNarudzbine() {
        return statusNarudzbine;
    }

    public void setStatusNarudzbine(StatusNarudzbine statusNarudzbine) {
        this.statusNarudzbine = statusNarudzbine;
    }

    public Set<NarudzbinaProizvodi> getNarudzbineProizvodi() {
        return narudzbineProizvodi;
    }

    public void setNarudzbineProizvodi(Set<NarudzbinaProizvodi> narudzbineProizvodi) {
        this.narudzbineProizvodi = narudzbineProizvodi;
    }

    public Boolean getNarucena() {
        return narucena;
    }

    public void setNarucena(Boolean narucena) {
        this.narucena = narucena;
    }
}
