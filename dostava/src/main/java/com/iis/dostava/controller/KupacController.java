package com.iis.dostava.controller;

import com.iis.dostava.service.KupacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/kupci")
public class KupacController {

    private KupacService kupacService;

    @Autowired
    public void setKupacService(KupacService kupacService) {
        this.kupacService = kupacService;
    }
}
