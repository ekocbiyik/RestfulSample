package com.ekocbiyik.service;

import com.ekocbiyik.dao.IPersonelDao;
import com.ekocbiyik.model.Personel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by enbiya on 02.05.2017.
 */
@Service
public class PersonelServiceImpl implements IPersonelService {

    @Autowired
    private IPersonelDao personelDao;

    @Transactional
    @Override
    public void savePersonel(Personel p) {
        personelDao.savePersonel(p);
    }

    @Transactional
    @Override
    public void deletePersonel(Personel p) {
        personelDao.deletePersonel(p);
    }

    @Transactional
    @Override
    public Personel getPersonelById(int id) {
        return personelDao.getPersonelById(id);
    }

    @Transactional
    @Override
    public List<Personel> getAllPersonels() {
        return personelDao.getAllPersonels();
    }
}
