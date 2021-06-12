package com.iis.dostava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("kupac")
public class Kupac extends User{

    @Column
    private String adresa;

    @JsonIgnore
    @OneToMany(mappedBy = "kupac", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Narudzbina> narudzbine = new HashSet<Narudzbina>();

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Set<Narudzbina> getNarudzbine() {
        return narudzbine;
    }

    public void setNarudzbine(Set<Narudzbina> narudzbine) {
        this.narudzbine = narudzbine;
    }
}
