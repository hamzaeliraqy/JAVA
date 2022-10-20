/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab4v1;

import com.mycompany.lab4v1.entity.appuser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hamza
 */
@Stateless
public class appuserFacade extends AbstractFacade<appuser> {

    @PersistenceContext(unitName = "SpriteHamza-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public appuserFacade() {
        super(appuser.class);
    }
    
}
