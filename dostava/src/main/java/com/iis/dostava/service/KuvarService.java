package com.iis.dostava.service;

import com.iis.dostava.dto.IdDTO;
import com.iis.dostava.dto.ProizvodDTO;
import com.iis.dostava.model.Kuvar;
import com.iis.dostava.model.Narudzbina;
import com.iis.dostava.model.NarudzbinaProizvodi;
import com.iis.dostava.model.Objekat;
import com.iis.dostava.repository.KuvarRepository;
import com.iis.dostava.repository.NarudzbinaProizvodiRepository;
import com.iis.dostava.repository.NarudzbinaRepository;
import com.iis.dostava.repository.StatusNarudzbineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class KuvarService {

    private KuvarRepository kuvarRepository;
    private NarudzbinaRepository narudzbinaRepository;
    private NarudzbinaProizvodiRepository narudzbinaProizvodiRepository;
    private StatusNarudzbineRepository statusNarudzbineRepository;

    @Autowired
    public void setStatusNarudzbineRepository(StatusNarudzbineRepository statusNarudzbineRepository) {
        this.statusNarudzbineRepository = statusNarudzbineRepository;
    }

    @Autowired
    public void setNarudzbinaProizvodiRepository(NarudzbinaProizvodiRepository narudzbinaProizvodiRepository) {
        this.narudzbinaProizvodiRepository = narudzbinaProizvodiRepository;
    }

    @Autowired
    public void setNarudzbinaRepository(NarudzbinaRepository narudzbinaRepository) {
        this.narudzbinaRepository = narudzbinaRepository;
    }

    @Autowired
    public void setKuvarRepository(KuvarRepository kuvarRepository) {
        this.kuvarRepository = kuvarRepository;
    }

    public Set<ProizvodDTO> getNarudzbinuZaPotvrdu(Kuvar kuvar){

        Objekat objekat = kuvar.getObjekat();
        Set<Narudzbina> narudzbine = narudzbinaRepository.findAllByObjekat(objekat);

        Narudzbina narudzbina = new Narudzbina();

        Set<ProizvodDTO> proizvodiDTO = new HashSet<>();

        for (Narudzbina n: narudzbine) {
            if(n.getStatusNarudzbine().getPrihvatioKuvar().equals(false) && n.getStatusNarudzbine().getOdbijena().equals(false)){
                narudzbina = n;
                Set<NarudzbinaProizvodi> narudzbinaProizvod = narudzbinaProizvodiRepository.findAllByNarudzbina(n);

                for (NarudzbinaProizvodi np: narudzbinaProizvod) {
                    ProizvodDTO p = new ProizvodDTO(np.getNarudzbina().getId(), np.getProizvod().getNaziv(), np.getProizvod().getCena(), np.getKolicina());
                    proizvodiDTO.add(p);
                }

                break;
            }else{
                return null;
            }
        }

        return proizvodiDTO;

    }

    public void potvrdiNarudzbinu(IdDTO narudzbinaId){

        Narudzbina narudzbina = narudzbinaRepository.findOneById(narudzbinaId.getId());

        narudzbina.getStatusNarudzbine().setPrihvatioKuvar(true);
        this.statusNarudzbineRepository.save(narudzbina.getStatusNarudzbine());

        return;

    }

    public void odbijNarudzbinu(IdDTO narudzbinaId){
        Narudzbina narudzbina = narudzbinaRepository.findOneById(narudzbinaId.getId());

        narudzbina.getStatusNarudzbine().setOdbijena(true);
        this.statusNarudzbineRepository.save(narudzbina.getStatusNarudzbine());

        return;

    }
}
