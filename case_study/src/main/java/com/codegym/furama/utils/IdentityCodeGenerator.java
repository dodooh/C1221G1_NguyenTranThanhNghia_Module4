package com.codegym.furama.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

public class IdentityCodeGenerator implements IdentifierGenerator, Configurable {

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
        longs.add(0L);
        Query query = session.createQuery(queryString);
        for(Object o : query.list()) {
            longs.add(Long.parseLong(((String) o).replace(prefix + "-", "")));
        }
        Long max = Collections.max(longs);

        return prefix + "-" + String.format("%04d",(max + 1));
    }

    @Override
    public void configure(Type type, Properties properties,
        ServiceRegistry serviceRegistry) throws MappingException {
        prefix = properties.getProperty("prefix");
    }

}
