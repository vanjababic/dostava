package com.iis.dostava.controller;

import com.iis.dostava.dto.BooleanDTO;
import com.iis.dostava.dto.PonudaDTO;
import com.iis.dostava.dto.SacuvajPonuduDTO;
import com.iis.dostava.model.Dostavljac;
import com.iis.dostava.service.PonudaService;
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
@RequestMapping(value="/ponude")
public class PonudaController {

    private PonudaService ponudaService;

    @Autowired
    public void setPonudaService(PonudaService ponudaService) {
        this.ponudaService = ponudaService;
    }



    @PostMapping(value="/sacuvajPonudu", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('DOSTAVLJAC')")
    public ResponseEntity<?> sacuvajPonudu(@RequestBody SacuvajPonuduDTO dto) throws Exception {

        Dostavljac user = (Dostavljac) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        ponudaService.sacuvajPonudu(user, dto);

        Map<String, String> result = new HashMap<String, String>();
        result.put("result", "success");

        return ResponseEntity.accepted().body(result);
    }

    @GetMapping(value="/dodeliDostavljaca",produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('DOSTAVLJAC')")
    public ResponseEntity<BooleanDTO> dodeliDostavljaca() {
        //Dostavljac user = (Dostavljac) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        BooleanDTO dodela = ponudaService.dodela();

        return new ResponseEntity<>(dodela, HttpStatus.OK);
    }
}
