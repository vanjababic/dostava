package com.iis.dostava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class StatusNarudzbine {

    @Id
    @SequenceGenerator(name="seq_statusNarudzbine", sequenceName = "seq_statusNarudzbine", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_statusNarudzbine")
    private Integer id;

    @Column
    private Boolean prihvatioKuvar;

    @Column
    private Boolean dodeljenDostavljac;

    @Column
    private Boolean preuzetaIzRestorana;

    @Column
    private LocalDateTime vremePreuzimanjaIzRestorana;

    @Column
    private Boolean dostavljenaKorisniku;

    @Column
    private LocalDateTime vremeDostavljanja;

    @OneToOne(mappedBy = "statusNarudzbine")
    private Narudzbina narudzbina;

    public StatusNarudzbine() {
    }

    public StatusNarudzbine(Integer id, Boolean prihvatioKuvar, Boolean dodeljenDostavljac, Boolean preuzetaIzRestorana, LocalDateTime vremePreuzimanjaIzRestorana, Boolean dostavljenaKorisniku, LocalDateTime vremeDostavljanja) {
        this.id = id;
        this.prihvatioKuvar = prihvatioKuvar;
        this.dodeljenDostavljac = dodeljenDostavljac;
        this.preuzetaIzRestorana = preuzetaIzRestorana;
        this.vremePreuzimanjaIzRestorana = vremePreuzimanjaIzRestorana;
        this.dostavljenaKorisniku = dostavljenaKorisniku;
        this.vremeDostavljanja = vremeDostavljanja;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getPrihvatioKuvar() {
        return prihvatioKuvar;
    }

    public void setPrihvatioKuvar(Boolean prihvatioKuvar) {
        this.prihvatioKuvar = prihvatioKuvar;
    }

    public Boolean getDodeljenDostavljac() {
        return dodeljenDostavljac;
    }

    public void setDodeljenDostavljac(Boolean dodeljenDostavljac) {
        this.dodeljenDostavljac = dodeljenDostavljac;
    }

    public Boolean getPreuzetaIzRestorana() {
        return preuzetaIzRestorana;
    }

    public void setPreuzetaIzRestorana(Boolean preuzetaIzRestorana) {
        this.preuzetaIzRestorana = preuzetaIzRestorana;
    }

    public LocalDateTime getVremePreuzimanjaIzRestorana() {
        return vremePreuzimanjaIzRestorana;
    }

    public void setVremePreuzimanjaIzRestorana(LocalDateTime vremePreuzimanjaIzRestorana) {
        this.vremePreuzimanjaIzRestorana = vremePreuzimanjaIzRestorana;
    }

    public Boolean getDostavljenaKorisniku() {
        return dostavljenaKorisniku;
    }

    public void setDostavljenaKorisniku(Boolean dostavljenaKorisniku) {
        this.dostavljenaKorisniku = dostavljenaKorisniku;
    }

    public LocalDateTime getVremeDostavljanja() {
        return vremeDostavljanja;
    }

    public void setVremeDostavljanja(LocalDateTime vremeDostavljanja) {
        this.vremeDostavljanja = vremeDostavljanja;
    }
}
