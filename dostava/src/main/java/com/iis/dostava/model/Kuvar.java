package com.iis.dostava.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("kuvar")
public class Kuvar extends User{
}
