package com.iis.dostava.controller;

import com.iis.dostava.service.StatusNarudzbineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/statusnarudzbine")
public class StatusNarudzbineController {

    private StatusNarudzbineService statusNarudzbineService;

    @Autowired
    public void setStatusNarudzbineService(StatusNarudzbineService statusNarudzbineService) {
        this.statusNarudzbineService = statusNarudzbineService;
    }
}
