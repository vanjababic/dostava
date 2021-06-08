package com.iis.dostava.repository;

import com.iis.dostava.model.Narudzbina;
import com.iis.dostava.model.NarudzbinaProizvodi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface NarudzbinaProizvodiRepository extends JpaRepository<NarudzbinaProizvodi, Integer> {

    Set<NarudzbinaProizvodi> findAllByNarudzbina(Narudzbina narudzbina);
}
