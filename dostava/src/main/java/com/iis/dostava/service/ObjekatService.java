package com.iis.dostava.service;

import com.iis.dostava.dto.IdDTO;
import com.iis.dostava.model.Narudzbina;
import com.iis.dostava.model.Objekat;
import com.iis.dostava.repository.NarudzbinaRepository;
import com.iis.dostava.repository.ObjekatRepository;
import com.iis.dostava.repository.StatusNarudzbineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjekatService {

    private ObjekatRepository objekatRepository;
    private NarudzbinaRepository narudzbinaRepository;
    private StatusNarudzbineRepository statusNarudzbineRepository;

    @Autowired
    public void setStatusNarudzbineRepository(StatusNarudzbineRepository statusNarudzbineRepository) {
        this.statusNarudzbineRepository = statusNarudzbineRepository;
    }

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

        Objekat objekat = objekatRepository.findOneById(1);

        narudzbina.setObjekat(objekat);
        narudzbina.getStatusNarudzbine().setDodeljenObjekat(true);
        narudzbina.setNarucena(true);

        this.narudzbinaRepository.save(narudzbina);
        this.statusNarudzbineRepository.save(narudzbina.getStatusNarudzbine());
    }
}
