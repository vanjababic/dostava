package com.iis.dostava.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("kuvar")
public class Kuvar extends User{

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Objekat objekat;

    public Objekat getObjekat() {
        return objekat;
    }

    public void setObjekat(Objekat objekat) {
        this.objekat = objekat;
    }
}
