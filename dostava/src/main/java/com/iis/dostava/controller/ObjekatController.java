package com.iis.dostava.controller;

import com.iis.dostava.service.ObjekatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/objekti")
public class ObjekatController {

    private ObjekatService objekatService;

    @Autowired
    public void setObjekatService(ObjekatService objekatService) {
        this.objekatService = objekatService;
    }
}
