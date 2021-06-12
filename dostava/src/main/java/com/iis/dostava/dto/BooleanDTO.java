package com.iis.dostava.dto;

public class BooleanDTO {

    private Integer narudzbinaId;
    private Integer dostavljacId;
    //private Boolean dodeljeno;

    public BooleanDTO() {
    }

    public Integer getNarudzbinaId() {
        return narudzbinaId;
    }

    public void setNarudzbinaId(Integer narudzbinaId) {
        this.narudzbinaId = narudzbinaId;
    }

    public Integer getDostavljacId() {
        return dostavljacId;
    }

    public void setDostavljacId(Integer dostavljacId) {
        this.dostavljacId = dostavljacId;
    }

    /*public Boolean getDodeljeno() {
        return dodeljeno;
    }

    public void setDodeljeno(Boolean dodeljeno) {
        this.dodeljeno = dodeljeno;
    }*/
}
