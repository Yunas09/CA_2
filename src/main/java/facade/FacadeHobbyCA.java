
package facade;

import Entity.HobbyCA;
import Entity.PersonCA;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class FacadeHobbyCA {

    EntityManagerFactory emf;

    public FacadeHobbyCA() {
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public FacadeHobbyCA(EntityManagerFactory emf) {
        this.emf = emf;
    }

      public HobbyCA addHobby(HobbyCA h)
    {
        EntityManager em = emf.createEntityManager();
       
        try
        {
            em.getTransaction().begin();
            em.persist(h);
            em.getTransaction().commit();
            return h;
        }
        finally
        {
            em.close();
        }
    }
    
    
    
    public HobbyCA getHobby(String hobbyName)
    {
        EntityManager em = emf.createEntityManager();

        HobbyCA h = null;
        
        try
        {
            em.getTransaction().begin();
            h = em.find(HobbyCA.class, hobbyName);
            em.getTransaction().commit();
            return h;
        }
        finally
        {
            em.close();
        }    
    }
}
