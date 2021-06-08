package com.iis.dostava.controller;

import com.iis.dostava.dto.IdDTO;
import com.iis.dostava.dto.ProizvodDTO;
import com.iis.dostava.model.Kupac;
import com.iis.dostava.model.Kuvar;
import com.iis.dostava.service.KuvarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(value="/kuvari")
public class KuvarController {

    private KuvarService kuvarService;

    @Autowired
    public void setKuvarService(KuvarService kuvarService) {
        this.kuvarService = kuvarService;
    }

    @GetMapping(value="/prikaziNarudzbinuZaPotvrdu",produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('KUVAR')")
    public ResponseEntity<Set<ProizvodDTO>> prikaziNarudzbinuZaPotvrdu() {
        Kuvar user = (Kuvar) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Set<ProizvodDTO> proizvodi = kuvarService.getNarudzbinuZaPotvrdu(user);

        return new ResponseEntity<>(proizvodi, HttpStatus.OK);
    }

    @PostMapping(value="/potvrdiNarudzbinu", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('KUVAR')")
    public ResponseEntity<?> potvrdiNarudzbinu(@RequestBody IdDTO idDto) throws Exception {

        Kuvar user = (Kuvar) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        kuvarService.potvrdiNarudzbinu(idDto);

        Map<String, String> result = new HashMap<String, String>();
        result.put("result", "success");

        return ResponseEntity.accepted().body(result);
    }

    @PostMapping(value="/odbijNarudzbinu", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('KUVAR')")
    public ResponseEntity<?> odbijNarudzbinu(@RequestBody IdDTO idDto) throws Exception {

        Kuvar user = (Kuvar) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        kuvarService.odbijNarudzbinu(idDto);

        Map<String, String> result = new HashMap<String, String>();
        result.put("result", "success");

        return ResponseEntity.accepted().body(result);
    }

}
