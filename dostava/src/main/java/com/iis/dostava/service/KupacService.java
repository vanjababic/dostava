package com.iis.dostava.service;

import com.iis.dostava.dto.ProizvodDTO;
import com.iis.dostava.model.Kupac;
import com.iis.dostava.model.Narudzbina;
import com.iis.dostava.model.NarudzbinaProizvodi;
import com.iis.dostava.repository.KupacRepository;
import com.iis.dostava.repository.NarudzbinaProizvodiRepository;
import com.iis.dostava.repository.NarudzbinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class KupacService {

    private KupacRepository kupacRepository;
    private NarudzbinaRepository narudzbinaRepository;
    private NarudzbinaProizvodiRepository narudzbinaProizvodiRepository;


    @Autowired
    public void setNarudzbinaProizvodiRepository(NarudzbinaProizvodiRepository narudzbinaProizvodiRepository) {
        this.narudzbinaProizvodiRepository = narudzbinaProizvodiRepository;
    }

    @Autowired
    public void setNarudzbinaRepository(NarudzbinaRepository narudzbinaRepository) {
        this.narudzbinaRepository = narudzbinaRepository;
    }

    @Autowired
    public void setKupacRepository(KupacRepository kupacRepository) {
        this.kupacRepository = kupacRepository;
    }

    public Set<ProizvodDTO> getNarudzbina(Kupac kupac){

        Set<Narudzbina> kupacNarudzbine = narudzbinaRepository.findOneByKupac(kupac);

        Narudzbina narudzbina = kupacNarudzbine.iterator().next();

        Set<NarudzbinaProizvodi> narudzbinaProizvod = narudzbinaProizvodiRepository.findAllByNarudzbina(narudzbina);

        Set<ProizvodDTO> proizvodiDTO = new HashSet<>();

        for (NarudzbinaProizvodi np: narudzbinaProizvod) {
                ProizvodDTO p = new ProizvodDTO(np.getNarudzbina().getId(), np.getProizvod().getNaziv(), np.getProizvod().getCena(), np.getKolicina());
                proizvodiDTO.add(p);

        }

        return proizvodiDTO;





    }
}

