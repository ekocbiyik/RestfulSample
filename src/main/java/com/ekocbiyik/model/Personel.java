package com.ekocbiyik.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by enbiya on 02.05.2017.
 */
@Entity
@Table(name = "t_personel")
@XmlRootElement
public class Personel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personel_id", nullable = false)
    private int personelId;

    @Column(name = "ad")
    private String ad;

    @Column(name = "soyad")
    private String soyad;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "arabaId")
    private List<Araba> arabalar;

    public Personel() {
    }

    public Personel(String ad, String soyad, List<Araba> arabalar) {
        this.ad = ad;
        this.soyad = soyad;
        this.arabalar = arabalar;
    }

    public int getPersonelId() {
        return personelId;
    }

    public void setPersonelId(int personelId) {
        this.personelId = personelId;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public List<Araba> getArabalar() {
        return arabalar;
    }

    public void setArabalar(List<Araba> arabalar) {
        this.arabalar = arabalar;
    }
}
