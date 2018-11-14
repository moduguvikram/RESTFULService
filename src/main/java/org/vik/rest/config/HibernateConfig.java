package org.vik.rest.config;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class HibernateConfig
{

    public EntityManagerFactory getAppEntityManagerFactory()
    {
        return Persistence
                .createEntityManagerFactory("PERSISTENCE");
    }
}
