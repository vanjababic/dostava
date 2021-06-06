package com.iis.dostava.repository;

import com.iis.dostava.model.Proizvod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProizvodRepository extends JpaRepository<Proizvod, Integer> {
}
