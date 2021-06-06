package com.iis.dostava.controller;

import com.iis.dostava.service.NarudzbinaProizvodiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/narudzbineproizvodi")
public class NarudzbinaProizvodiController {

    private NarudzbinaProizvodiService narudzbinaProizvodiService;

    @Autowired
    public void setNarudzbinaProizvodiService(NarudzbinaProizvodiService narudzbinaProizvodiService) {
        this.narudzbinaProizvodiService = narudzbinaProizvodiService;
    }
}
