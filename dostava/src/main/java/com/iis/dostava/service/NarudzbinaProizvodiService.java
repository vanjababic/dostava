package com.iis.dostava.service;

import com.iis.dostava.repository.NarudzbinaProizvodiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NarudzbinaProizvodiService {

    private NarudzbinaProizvodiRepository narudzbinaProizvodiRepository;

    @Autowired
    public void setNarudzbinaProizvodiRepository(NarudzbinaProizvodiRepository narudzbinaProizvodiRepository) {
        this.narudzbinaProizvodiRepository = narudzbinaProizvodiRepository;
    }
}
