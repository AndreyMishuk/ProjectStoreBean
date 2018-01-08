/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.service.projectstorebeans.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.service.projectstorebeans.entity.Producer;

/**
 *
 * @author andrey
 */
@Stateless
public class ProducerFacade extends AbstractFacade<Producer> {

    @PersistenceContext(unitName = "net.service_ProjectStoreBeans_war_0.01PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProducerFacade() {
        super(Producer.class);
    }
    
}
