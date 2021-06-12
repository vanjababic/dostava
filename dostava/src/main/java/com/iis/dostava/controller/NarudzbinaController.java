package com.iis.dostava.controller;

import com.iis.dostava.dto.IdDTO;
import com.iis.dostava.dto.SacuvajPonuduDTO;
import com.iis.dostava.model.Dostavljac;
import com.iis.dostava.service.NarudzbinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/narudzbine")
public class NarudzbinaController {

    private NarudzbinaService narudzbinaService;

    @Autowired
    public void setNarudzbinaService(NarudzbinaService narudzbinaService) {
        this.narudzbinaService = narudzbinaService;
    }


    @PostMapping(value="/preuzetaIzRestorana", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('DOSTAVLJAC')")
    public ResponseEntity<?> preuzetaIzRestorana(@RequestBody IdDTO idDto) throws Exception {

        narudzbinaService.preuzetaIzRestorana(idDto);

        Map<String, String> result = new HashMap<String, String>();
        result.put("result", "success");

        return ResponseEntity.accepted().body(result);
    }


    @PostMapping(value="/dostavljenaKorisniku", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('DOSTAVLJAC')")
    public ResponseEntity<?> dostavljenaKorisniku(@RequestBody IdDTO idDto) throws Exception {

        narudzbinaService.dostavljenaKorisniku(idDto);

        Map<String, String> result = new HashMap<String, String>();
        result.put("result", "success");

        return ResponseEntity.accepted().body(result);
    }
}
