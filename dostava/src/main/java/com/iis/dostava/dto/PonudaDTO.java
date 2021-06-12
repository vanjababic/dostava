package com.iis.dostava.dto;

public class PonudaDTO {

    private String adresaKupca;
    private String adresaObjekta;
    private Integer ponudaId;

    public PonudaDTO(String adresaKupca, String adresaObjekta, Integer ponudaId) {
        this.adresaKupca = adresaKupca;
        this.adresaObjekta = adresaObjekta;
        this.ponudaId = ponudaId;
    }

    public PonudaDTO() {
    }

    public String getAdresaKupca() {
        return adresaKupca;
    }

    public void setAdresaKupca(String adresaKupca) {
        this.adresaKupca = adresaKupca;
    }

    public String getAdresaObjekta() {
        return adresaObjekta;
    }

    public void setAdresaObjekta(String adresaObjekta) {
        this.adresaObjekta = adresaObjekta;
    }

    public Integer getPonudaId() {
        return ponudaId;
    }

    public void setPonudaId(Integer ponudaId) {
        this.ponudaId = ponudaId;
    }
}
