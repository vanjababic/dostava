package com.iis.dostava.service;

import com.iis.dostava.repository.StatusNarudzbineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusNarudzbineService {

    private StatusNarudzbineRepository statusNarudzbineRepository;

    @Autowired
    public void setStatusNarudzbineRepository(StatusNarudzbineRepository statusNarudzbineRepository) {
        this.statusNarudzbineRepository = statusNarudzbineRepository;
    }
}
