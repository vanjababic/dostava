package com.iis.dostava.controller;

import com.iis.dostava.service.KuvarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/kuvari")
public class KuvarController {

    private KuvarService kuvarService;

    @Autowired
    public void setKuvarService(KuvarService kuvarService) {
        this.kuvarService = kuvarService;
    }
}
