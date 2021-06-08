package com.iis.dostava.controller;

import com.iis.dostava.dto.IdDTO;
import com.iis.dostava.model.Kupac;
import com.iis.dostava.service.ObjekatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping(value="/objekti")
public class ObjekatController {

    private ObjekatService objekatService;

    @Autowired
    public void setObjekatService(ObjekatService objekatService) {
        this.objekatService = objekatService;
    }



    @PostMapping(value="/dodeliObjekatNarudzbini", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('KUPAC')")
    public ResponseEntity<?> dodeliObjekatNarudzbini(@RequestBody IdDTO idDto) throws Exception {

        Kupac user = (Kupac) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        objekatService.dodeliObjekatNarudzbini(idDto);

        Map<String, String> result = new HashMap<String, String>();
        result.put("result", "success");

        return ResponseEntity.accepted().body(result);
    }

}
