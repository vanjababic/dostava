package com.iis.dostava.service;

import com.iis.dostava.repository.ObjekatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjekatService {

    private ObjekatRepository objekatRepository;

    @Autowired
    public void setObjekatRepository(ObjekatRepository objekatRepository) {
        this.objekatRepository = objekatRepository;
    }
}
