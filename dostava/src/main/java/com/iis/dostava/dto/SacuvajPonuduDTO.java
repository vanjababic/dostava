package com.iis.dostava.dto;

public class SacuvajPonuduDTO {

    private Integer narudzbinaId;
    private Integer vreme;

    public SacuvajPonuduDTO(Integer narudzbinaId, Integer vreme) {
        this.narudzbinaId = narudzbinaId;
        this.vreme = vreme;
    }

    public SacuvajPonuduDTO() {
    }

    public Integer getNarudzbinaId() {
        return narudzbinaId;
    }

    public void setNarudzbinaId(Integer narudzbinaId) {
        this.narudzbinaId = narudzbinaId;
    }

    public Integer getVreme() {
        return vreme;
    }

    public void setVreme(Integer vreme) {
        this.vreme = vreme;
    }
}
