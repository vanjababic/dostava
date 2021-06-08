package com.iis.dostava.repository;

import com.iis.dostava.model.Objekat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjekatRepository extends JpaRepository<Objekat, Integer> {
    Objekat findOneById(Integer id);
}
