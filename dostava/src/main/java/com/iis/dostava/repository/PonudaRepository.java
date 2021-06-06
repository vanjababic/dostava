package com.iis.dostava.repository;

import com.iis.dostava.model.Ponuda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PonudaRepository extends JpaRepository<Ponuda, Integer> {
}
