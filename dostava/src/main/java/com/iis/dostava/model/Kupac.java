package com.iis.dostava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("kupac")
public class Kupac extends User{

    @JsonIgnore
    @OneToMany(mappedBy = "kupac", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Narudzbina> narudzbine = new HashSet<Narudzbina>();



}
