package com.iis.dostava.service;

import com.iis.dostava.dto.IdDTO;
import com.iis.dostava.model.Narudzbina;
import com.iis.dostava.model.Objekat;
import com.iis.dostava.repository.NarudzbinaRepository;
import com.iis.dostava.repository.ObjekatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjekatService {

    private ObjekatRepository objekatRepository;
    private NarudzbinaRepository narudzbinaRepository;

    @Autowired
    public void setNarudzbinaRepository(NarudzbinaRepository narudzbinaRepository) {
        this.narudzbinaRepository = narudzbinaRepository;
    }

    @Autowired
    public void setObjekatRepository(ObjekatRepository objekatRepository) {
        this.objekatRepository = objekatRepository;
    }

    public void dodeliObjekatNarudzbini(IdDTO narudzbinaId){

        Narudzbina narudzbina = narudzbinaRepository.findOneById(narudzbinaId.getId());

        Objekat objekat = objekatRepository.findOneById(2);

        narudzbina.setObjekat(objekat);
        this.narudzbinaRepository.save(narudzbina);

    }
}
