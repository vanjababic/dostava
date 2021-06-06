package com.iis.dostava.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("kupac")
public class Kupac extends User{
}
