package com.iis.dostava.service;


import com.iis.dostava.repository.ProizvodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProizvodService {

    private ProizvodRepository proizvodRepository;

    @Autowired
    public void setProizvodRepository(ProizvodRepository proizvodRepository) {
        this.proizvodRepository = proizvodRepository;
    }
}
