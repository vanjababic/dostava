package com.iis.dostava.service;

import com.iis.dostava.dto.PonudaDTO;
import com.iis.dostava.dto.ProizvodDTO;
import com.iis.dostava.model.Narudzbina;
import com.iis.dostava.model.Ponuda;
import com.iis.dostava.repository.DostavljacRepository;
import com.iis.dostava.repository.NarudzbinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DostavljacService {

    private DostavljacRepository dostavljacRepository;
    private NarudzbinaRepository narudzbinaRepository;

    @Autowired
    public void setNarudzbinaRepository(NarudzbinaRepository narudzbinaRepository) {
        this.narudzbinaRepository = narudzbinaRepository;
    }

    @Autowired
    public void setDostavljacRepository(DostavljacRepository dostavljacRepository) {
        this.dostavljacRepository = dostavljacRepository;
    }


    public Set<PonudaDTO> getNarudzbineZaPonudu(){

        //List<Narudzbina> narudzbine = narudzbinaRepository.findAll();
        Narudzbina narudzbine =  narudzbinaRepository.findOneById(1);


        Set<PonudaDTO> ponude = new HashSet<>();

        //for (Narudzbina n: narudzbine) {
            if(narudzbine.getStatusNarudzbine().getOdbijena().equals(false) && narudzbine.getStatusNarudzbine().getPrihvatioKuvar().equals(true) && narudzbine.getStatusNarudzbine().getDodeljenDostavljac().equals(false)){
                String adresaKupca = narudzbine.getKupac().getAdresa();
                String adresaObjekta = narudzbine.getObjekat().getAdresa();
                Integer ponudaId = narudzbine.getId();
                PonudaDTO p = new PonudaDTO(adresaKupca, adresaObjekta, ponudaId);
                ponude.add(p);
            }else {
                return null;
            }
        //}

        return ponude;

    }

}
