package com.iis.dostava.service;

import com.iis.dostava.dto.BooleanDTO;
import com.iis.dostava.dto.SacuvajPonuduDTO;
import com.iis.dostava.model.Dostavljac;
import com.iis.dostava.model.Narudzbina;
import com.iis.dostava.model.Ponuda;
import com.iis.dostava.repository.NarudzbinaRepository;
import com.iis.dostava.repository.PonudaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PonudaService {

    private PonudaRepository ponudaRepository;
    private NarudzbinaRepository narudzbinaRepository;

    @Autowired
    public void setNarudzbinaRepository(NarudzbinaRepository narudzbinaRepository) {
        this.narudzbinaRepository = narudzbinaRepository;
    }

    @Autowired
    public void setPonudaRepository(PonudaRepository ponudaRepository) {

        this.ponudaRepository = ponudaRepository;
    }


    public void sacuvajPonudu(Dostavljac dostavljac, SacuvajPonuduDTO dto){

        Ponuda ponuda = new Ponuda();
        ponuda.setDostavljac(dostavljac);

        Narudzbina narudzbina = narudzbinaRepository.findOneById(dto.getNarudzbinaId());
        ponuda.setNarudzbina(narudzbina);

        ponuda.setPotrebnoVreme(dto.getVreme());

        ponuda.setPrihvacena(false);

        ponudaRepository.save(ponuda);


    }

    public BooleanDTO dodela(){

        Narudzbina narudzbina = narudzbinaRepository.findOneById(1);
        List<Ponuda> ponude = ponudaRepository.findAllByNarudzbina(narudzbina);

        Ponuda najboljaPonuda = new Ponuda();
        najboljaPonuda = ponude.iterator().next();

        for (Ponuda p: ponude) {
            if (p.getPotrebnoVreme() < najboljaPonuda.getPotrebnoVreme()){
                najboljaPonuda = p;
            }
        }

        BooleanDTO booleanDTO = new BooleanDTO();
        booleanDTO.setDostavljacId(najboljaPonuda.getDostavljac().getId());
        booleanDTO.setNarudzbinaId(najboljaPonuda.getNarudzbina().getId());

        najboljaPonuda.getNarudzbina().getStatusNarudzbine().setDodeljenDostavljac(true);
        narudzbinaRepository.save(najboljaPonuda.getNarudzbina());

        return booleanDTO;

    }


}
