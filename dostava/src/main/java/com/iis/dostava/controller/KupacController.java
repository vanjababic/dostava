package com.iis.dostava.controller;

import com.iis.dostava.dto.ProizvodDTO;
import com.iis.dostava.model.Kupac;
import com.iis.dostava.service.KupacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value="/kupci")
public class KupacController {

    private KupacService kupacService;

    @Autowired
    public void setKupacService(KupacService kupacService) {
        this.kupacService = kupacService;
    }

    @GetMapping(value="/naruciNarudzbinu",produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('KUPAC')")
    public ResponseEntity<Set<ProizvodDTO>> naruciNarudzbinu() {
        Kupac user = (Kupac) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Set<ProizvodDTO> proizvodi = kupacService.getNarudzbina(user);

        return new ResponseEntity<>(proizvodi, HttpStatus.OK);
    }

}
