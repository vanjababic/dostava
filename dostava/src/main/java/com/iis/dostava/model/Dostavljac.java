package com.iis.dostava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("dostavljac")
public class Dostavljac extends User{

    @JsonIgnore
    @OneToMany(mappedBy = "dostavljac", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Ponuda> ponude = new HashSet<Ponuda>();


}
