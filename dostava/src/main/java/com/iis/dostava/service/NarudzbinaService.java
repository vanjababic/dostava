package com.iis.dostava.service;

import com.iis.dostava.repository.NarudzbinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NarudzbinaService {

    private NarudzbinaRepository narudzbinaRepository;

    @Autowired
    public void setNarudzbinaRepository(NarudzbinaRepository narudzbinaRepository) {
        this.narudzbinaRepository = narudzbinaRepository;
    }
}
