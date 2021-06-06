package com.iis.dostava.service;

import com.iis.dostava.repository.PonudaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PonudaService {

    private PonudaRepository ponudaRepository;

    @Autowired
    public void setPonudaRepository(PonudaRepository ponudaRepository) {
        this.ponudaRepository = ponudaRepository;
    }
}
