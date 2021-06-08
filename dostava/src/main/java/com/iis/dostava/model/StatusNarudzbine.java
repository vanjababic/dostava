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
    private Boolean odbijena;

    @Column
    private Boolean dodeljenObjekat;

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

    public StatusNarudzbine(Integer id, Boolean odbijena, Boolean dodeljenObjekat, Boolean prihvatioKuvar, Boolean dodeljenDostavljac, Boolean preuzetaIzRestorana, LocalDateTime vremePreuzimanjaIzRestorana, Boolean dostavljenaKorisniku, LocalDateTime vremeDostavljanja, Narudzbina narudzbina) {
        this.id = id;
        this.odbijena = odbijena;
        this.dodeljenObjekat = dodeljenObjekat;
        this.prihvatioKuvar = prihvatioKuvar;
        this.dodeljenDostavljac = dodeljenDostavljac;
        this.preuzetaIzRestorana = preuzetaIzRestorana;
        this.vremePreuzimanjaIzRestorana = vremePreuzimanjaIzRestorana;
        this.dostavljenaKorisniku = dostavljenaKorisniku;
        this.vremeDostavljanja = vremeDostavljanja;
        this.narudzbina = narudzbina;
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

    public Boolean getOdbijena() {
        return odbijena;
    }

    public void setOdbijena(Boolean odbijena) {
        this.odbijena = odbijena;
    }

    public Boolean getDodeljenObjekat() {
        return dodeljenObjekat;
    }

    public void setDodeljenObjekat(Boolean dodeljenObjekat) {
        this.dodeljenObjekat = dodeljenObjekat;
    }

    public Narudzbina getNarudzbina() {
        return narudzbina;
    }

    public void setNarudzbina(Narudzbina narudzbina) {
        this.narudzbina = narudzbina;
    }
}
