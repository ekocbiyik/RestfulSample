package com.ekocbiyik.dao;

import com.ekocbiyik.model.Personel;

import java.util.List;

/**
 * Created by enbiya on 02.05.2017.
 */
public interface IPersonelDao {

    void savePersonel(Personel p);

    void deletePersonel(Personel p);

    Personel getPersonelById(int id);

    List<Personel> getAllPersonels();
}
