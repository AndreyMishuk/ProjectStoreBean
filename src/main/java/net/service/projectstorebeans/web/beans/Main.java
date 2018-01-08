package net.service.projectstorebeans.web.beans;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("store");
        EntityManager em = emf.createEntityManager();
        em.close();
        emf.close();
    }

}
