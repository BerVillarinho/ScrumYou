/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.scrumyou.control;

import br.com.scrumyou.model.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.core.EntityTag;

/**
 *
 * @author Disguise
 */
@ManagedBean
@RequestScoped
public class SignUpManagedBean {
    private EntityManagerFactory emf;
    private EntityTransaction trx;
    private User user;
    
    /**
     * Creates a new instance of SignUpManagedBean
     */
    public SignUpManagedBean() {
        user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String getSignUp(){
        emf = Persistence.createEntityManagerFactory("ScrumYouPU");
        EntityManager em = emf.createEntityManager();
        trx = em.getTransaction();
        
        trx.begin();
        em.persist(user);
        
        trx.commit();
        
        
        
        return "Ok";
    }
    
}
