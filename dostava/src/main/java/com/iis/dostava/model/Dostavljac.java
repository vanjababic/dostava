package com.iis.dostava.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("dostavljac")
public class Dostavljac extends User{

}
