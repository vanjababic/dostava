package com.iis.dostava.repository;

import com.iis.dostava.model.Narudzbina;
import com.iis.dostava.model.Ponuda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PonudaRepository extends JpaRepository<Ponuda, Integer> {

    List<Ponuda> findAllByNarudzbina(Narudzbina narudzbina);
}
