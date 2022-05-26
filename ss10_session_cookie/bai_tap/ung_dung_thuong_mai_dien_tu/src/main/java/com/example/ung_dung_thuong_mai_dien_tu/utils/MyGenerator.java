package com.example.ung_dung_thuong_mai_dien_tu.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.Query;

public class MyGenerator implements IdentifierGenerator {

    private String prefix;

    @Override
    public Serializable generate(
        SharedSessionContractImplementor session, Object obj)
        throws HibernateException {

        String queryString = String.format("select %s from %s",
            session.getEntityPersister(obj.getClass().getName(), obj)
                .getIdentifierPropertyName(),
            obj.getClass().getSimpleName());
        List<Long> longs = new ArrayList<>();
        Query query = session.createQuery(queryString);
        for(Object o : query.list()) {
            longs.add(Long.parseLong(o.toString()));
        }

        Long newId;
        do {
            newId = Math.round(Math.random() * 8999) + 1000;
        } while(longs.contains(newId));
        System.out.println("NEW Generated ID: " + newId );
        return newId;
    }
}

