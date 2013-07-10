/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datnguyen.testRestful.ejb;

import com.datnguyen.testRestful.entity.Users;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class ConfigBean {
    
    @PersistenceContext(unitName = "testRestfulServicePU")
    private EntityManager em;

    @PostConstruct
    public void init() {
        // create the event owner
        Users dat = new Users();
        dat.setUsername("dat");
        dat.setLatitude(37.477719);
        dat.setLongtitude(-121.925578);
        em.persist(dat);
        
        Users anna = new Users();
        anna.setUsername("anna");
        anna.setLatitude(37.431566);
        anna.setLongtitude(-121.891257);
        em.persist(anna);
        
    }
}

