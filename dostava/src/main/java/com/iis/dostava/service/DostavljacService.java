package com.iis.dostava.service;

import com.iis.dostava.repository.DostavljacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DostavljacService {

    private DostavljacRepository dostavljacRepository;

    @Autowired
    public void setDostavljacRepository(DostavljacRepository dostavljacRepository) {
        this.dostavljacRepository = dostavljacRepository;
    }
}
