package com.iis.dostava.controller;

import com.iis.dostava.service.PonudaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/ponude")
public class PonudaController {

    private PonudaService ponudaService;

    @Autowired
    public void setPonudaService(PonudaService ponudaService) {
        this.ponudaService = ponudaService;
    }
}
