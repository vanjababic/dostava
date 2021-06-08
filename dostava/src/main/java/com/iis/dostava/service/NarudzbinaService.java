package com.iis.dostava.service;

import com.iis.dostava.model.Narudzbina;
import com.iis.dostava.model.Objekat;
import com.iis.dostava.repository.NarudzbinaRepository;
import com.iis.dostava.repository.ObjekatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class NarudzbinaService {

    private NarudzbinaRepository narudzbinaRepository;
    private ObjekatRepository objekatRepository;

    @Autowired
    public void setObjekatRepository(ObjekatRepository objekatRepository) {
        this.objekatRepository = objekatRepository;
    }

    @Autowired
    public void setNarudzbinaRepository(NarudzbinaRepository narudzbinaRepository) {
        this.narudzbinaRepository = narudzbinaRepository;
    }


    public void dodeliObjekat(){

        List<Narudzbina> narudzbine = narudzbinaRepository.findAll();

        List<Narudzbina> neobradjeneNarudzbine;

        for (Narudzbina n : narudzbine) {
            if (n.getObjekat().equals(null)){
                Objekat o = getNajbliziObjekat();
                n.setObjekat(o);
                this.narudzbinaRepository.save(n);
            }else{
                return;
            }
        }
    }

    public Objekat getNajbliziObjekat(){
        Objekat o = objekatRepository.findOneById(1);

        return o;
    }
}
