/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbstructure;

import Entity.HobbyCA;
import Entity.PersonCA;
import Entity.PhoneCA;
import facade.FacadeHobbyCA;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Populate {
         FacadeHobbyCA hb;

     public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "CA_2" );
        EntityManager em = emf.createEntityManager();
                List<HobbyCA> hobbies = new ArrayList<>();

        em.getTransaction().begin();
        
              
        
        
//        hobbies.add(new HobbyCA("asd", "akl"));
        PersonCA p = new PersonCA( "Dan", "Mark", hobbies);
        em.persist(p);
        System.out.println(p);
        
//        hobbies.add(new HobbyCA("jkl", "li"));
        p = new PersonCA("Mark", "Benson", hobbies);
        em.persist(p);
        
        
//        hobbies.add(new HobbyCA("qqq", "oioi"));
        p = new PersonCA("Ben", "Winter", hobbies);
        em.persist(p);
        
        
        
        
        
        
        
        HobbyCA h = new HobbyCA("fodbold", "fodbold");
        em.persist(h);
         h = new HobbyCA("håndbold", "håndbold");
        em.persist(h);
         h = new HobbyCA("tennis", "tennis");
        em.persist(h);
        
        PhoneCA ph = new PhoneCA("6032243", "mobil");
        em.persist(ph);
        ph = new PhoneCA("6962243", "mobil");
        em.persist(ph);
        ph = new PhoneCA("124243", "mobil");
        em.persist(ph);
        
        em.getTransaction().commit();
        em.close();
    }
}
