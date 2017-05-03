package com.ekocbiyik.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by enbiya on 02.05.2017.
 */
@Entity
@Table(name = "t_araba")
@XmlRootElement
public class Araba {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "araba_id", nullable = false)
    private int arabaId;

    @Column(name = "marka")
    private String marka;

    @Column(name = "renk")
    private String renk;

    public Araba() {
    }

    public Araba(String marka, String renk) {
        this.marka = marka;
        this.renk = renk;
    }

    public int getArabaId() {
        return arabaId;
    }

    public void setArabaId(int arabaId) {
        this.arabaId = arabaId;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    @Override
    public String toString() {
        return "{" + arabaId + " " + marka + " " + renk + "}";
    }
}


