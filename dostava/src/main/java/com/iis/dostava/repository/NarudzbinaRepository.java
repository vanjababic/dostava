package com.iis.dostava.repository;

import com.iis.dostava.model.Kupac;
import com.iis.dostava.model.Narudzbina;
import com.iis.dostava.model.Objekat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface NarudzbinaRepository extends JpaRepository<Narudzbina, Integer> {

    Set<Narudzbina> findOneByKupac(Kupac kupac);
    Narudzbina findOneById(Integer id);
    Set<Narudzbina> findAllByObjekat(Objekat objekat);
}
