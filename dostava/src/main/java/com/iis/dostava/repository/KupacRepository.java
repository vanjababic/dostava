package com.iis.dostava.repository;

import com.iis.dostava.model.Kupac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KupacRepository extends JpaRepository<Kupac, Integer> {
}
