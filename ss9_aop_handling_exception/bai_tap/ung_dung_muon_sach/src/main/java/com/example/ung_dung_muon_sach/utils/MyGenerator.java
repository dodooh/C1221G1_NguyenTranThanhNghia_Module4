package com.example.ung_dung_muon_sach.utils;

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
            newId = Math.round(Math.random() * 89999) + 10000;
        } while(longs.contains(newId));
        System.out.println("NEW Generated ID: " + newId );
        return newId;
//        return prefix + "-" + (max + 1);
    }
//
//    @Override
//    public void configure(Type type, Properties properties,
//        ServiceRegistry serviceRegistry) throws MappingException {
//        prefix = properties.getProperty("prefix");
//    }
}
