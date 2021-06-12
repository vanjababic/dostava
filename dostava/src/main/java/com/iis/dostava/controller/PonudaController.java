package com.iis.dostava.controller;

import com.iis.dostava.dto.IdDTO;
import com.iis.dostava.dto.SacuvajPonuduDTO;
import com.iis.dostava.model.Dostavljac;
import com.iis.dostava.model.Kuvar;
import com.iis.dostava.service.PonudaService;
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
}
