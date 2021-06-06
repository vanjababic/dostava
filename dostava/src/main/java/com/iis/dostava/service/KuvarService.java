package com.iis.dostava.service;

import com.iis.dostava.repository.KuvarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KuvarService {

    private KuvarRepository kuvarRepository;

    @Autowired
    public void setKuvarRepository(KuvarRepository kuvarRepository) {
        this.kuvarRepository = kuvarRepository;
    }
}
