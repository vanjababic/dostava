package com.iis.dostava.model;

import javax.persistence.*;

@Entity
public class Ponuda {

    @Id
    @SequenceGenerator(name="seq_ponuda", sequenceName = "seq_ponuda", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ponuda")
    private Integer id;
}
