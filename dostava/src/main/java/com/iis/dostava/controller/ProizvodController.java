package com.iis.dostava.controller;

import com.iis.dostava.service.ProizvodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/proizvodi")
public class ProizvodController {

    private ProizvodService proizvodService;

    @Autowired
    public void setProizvodService(ProizvodService proizvodService) {
        this.proizvodService = proizvodService;
    }
}
