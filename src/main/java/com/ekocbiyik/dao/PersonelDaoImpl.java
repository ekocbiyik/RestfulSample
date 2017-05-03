package com.ekocbiyik.dao;

import com.ekocbiyik.model.Personel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by enbiya on 02.05.2017.
 */
@Component
public class PersonelDaoImpl implements IPersonelDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void savePersonel(Personel p) {
        getCurrentSession().saveOrUpdate(p);
    }

    @Override
    public void deletePersonel(Personel p) {
        getCurrentSession().delete(p);
    }

    @Override
    public Personel getPersonelById(int id) {
        return (Personel) getCurrentSession().createQuery("from Personel where personelId = :id").setParameter("id", id).uniqueResult();
    }

    @Override
    public List<Personel> getAllPersonels() {
        return getCurrentSession().createQuery("from Personel").list();
    }
}
