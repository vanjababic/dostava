package com.iis.dostava.controller;

import com.iis.dostava.service.DostavljacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/dostavljaci")
public class DostavljacController {

    private DostavljacService dostavljacService;

    @Autowired
    public void setDostavljacService(DostavljacService dostavljacService) {
        this.dostavljacService = dostavljacService;
    }
}
