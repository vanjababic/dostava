package com.iis.dostava.dto;


public class ProizvodDTO {

    private Integer narudzbinaId;

    private String naziv;

    private Double cena;

    private Integer kolicina;

    public ProizvodDTO(Integer narudzbinaId, String naziv, Double cena, Integer kolicina) {
        this.narudzbinaId = narudzbinaId;
        this.naziv = naziv;
        this.cena = cena;
        this.kolicina = kolicina;
    }

    public ProizvodDTO() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public Integer getNarudzbinaId() {
        return narudzbinaId;
    }

    public void setNarudzbinaId(Integer narudzbinaId) {
        this.narudzbinaId = narudzbinaId;
    }
}

