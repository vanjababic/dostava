package com.iis.dostava.service;

import com.iis.dostava.repository.KupacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KupacService {

    private KupacRepository kupacRepository;

    @Autowired
    public void setKupacRepository(KupacRepository kupacRepository) {
        this.kupacRepository = kupacRepository;
    }
}
