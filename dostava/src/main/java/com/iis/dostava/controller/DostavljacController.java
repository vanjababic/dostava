package com.iis.dostava.controller;

import com.iis.dostava.dto.PonudaDTO;
import com.iis.dostava.dto.ProizvodDTO;
import com.iis.dostava.model.Dostavljac;
import com.iis.dostava.model.Kuvar;
import com.iis.dostava.service.DostavljacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value="/dostavljaci")
public class DostavljacController {

    private DostavljacService dostavljacService;

    @Autowired
    public void setDostavljacService(DostavljacService dostavljacService) {
        this.dostavljacService = dostavljacService;
    }

    @GetMapping(value="/prikaziNarudzbineZaPonudu",produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('DOSTAVLJAC')")
    public ResponseEntity<Set<PonudaDTO>> prikaziNarudzbineZaPonudu() {
        //Dostavljac user = (Dostavljac) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Set<PonudaDTO> proizvodi = dostavljacService.getNarudzbineZaPonudu();

        return new ResponseEntity<>(proizvodi, HttpStatus.OK);
    }
}
