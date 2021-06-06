package com.iis.dostava.controller;

import com.iis.dostava.service.NarudzbinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/narudzbine")
public class NarudzbinaController {

    private NarudzbinaService narudzbinaService;

    @Autowired
    public void setNarudzbinaService(NarudzbinaService narudzbinaService) {
        this.narudzbinaService = narudzbinaService;
    }
}
