package com.iis.dostava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Ponuda {

    @Id
    @SequenceGenerator(name="seq_ponuda", sequenceName = "seq_ponuda", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ponuda")
    private Integer id;

    @Column
    private Integer potrebnoVreme;

    @Column
    private Boolean prihvacena;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Narudzbina narudzbina;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Dostavljac dostavljac;

    public Ponuda() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPotrebnoVreme() {
        return potrebnoVreme;
    }

    public void setPotrebnoVreme(Integer potrebnoVreme) {
        this.potrebnoVreme = potrebnoVreme;
    }

    public Boolean getPrihvacena() {
        return prihvacena;
    }

    public void setPrihvacena(Boolean prihvacena) {
        this.prihvacena = prihvacena;
    }

    public Narudzbina getNarudzbina() {
        return narudzbina;
    }

    public void setNarudzbina(Narudzbina narudzbina) {
        this.narudzbina = narudzbina;
    }

    public Dostavljac getDostavljac() {
        return dostavljac;
    }

    public void setDostavljac(Dostavljac dostavljac) {
        this.dostavljac = dostavljac;
    }
}
