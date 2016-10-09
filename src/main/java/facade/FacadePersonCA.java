


package facade;

import Entity.HobbyCA;
import Entity.PersonCA;
import static Entity.PersonCA_.firstName;
import static Entity.PersonCA_.lastName;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import static org.eclipse.persistence.expressions.ExpressionOperator.count;




public class FacadePersonCA {
  EntityManagerFactory emf;
    
    public FacadePersonCA()
    {
    }

    public void setEmf(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    
    
    public FacadePersonCA(EntityManagerFactory emf)
    {
        this.emf = emf;
    }   
    
    
    public PersonCA getPerson(int id)
    {
        EntityManager em = emf.createEntityManager();

        PersonCA p = null;
        
        try
        {
            em.getTransaction().begin();
            p = em.find(PersonCA.class, id);
            em.getTransaction().commit();
            return p;
        }
        finally
        {
            em.close();
        }    
    }
    
    
    public List<PersonCA> getPersons()
    {
        EntityManager em = emf.createEntityManager();

        List<PersonCA> persons = null;
        
        try
        {
            em.getTransaction().begin();
            persons = em.createQuery("Select * from PersonCA").getResultList();
            em.getTransaction().commit();
            return persons;
        }
        finally
        {
            em.close();
        }
    }
    
    public ArrayList getPersonByInfo(int id){
     EntityManager em = emf.createEntityManager();
     
     PersonCA p;
     HobbyCA h;
     ArrayList ar = new ArrayList();
     
        try {
            em.getTransaction().begin();
            p = em.find(PersonCA.class, id);
            h = em.find(HobbyCA.class, id);
            
            
            if (p.equals(h)) {
                ar.add(p);
                ar.add(h);

                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
        return ar;
    }
    
    
     public List <PersonCA> addPerson(PersonCA p) throws SQLException
    {
        EntityManager em = emf.createEntityManager();
        PreparedStatement ps = null;
        try
        {
            em.getTransaction().begin();
            ps= (PreparedStatement) em.createQuery("INSERT INTO `ca_2`.`personca` (`Firstname`, `Lastname`) VALUES ('\" + firstName + \"', '\" + lastName + \"');\";");
            
            ps.setString(1, p.getFirstName());
            ps.setString(2,p.getLastName());
            em.getTransaction().commit();
            
            return (List<PersonCA>) p;
           
           
        }
        finally
        {
            em.close();
        }
    }
    
   public PersonCA deletePerson(int id)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            PersonCA p = em.find(PersonCA.class, id);
            em.remove(p);
            em.getTransaction().commit();
            return p;
        }
        finally
        {
            em.close();
        }
    }
    
    public PersonCA editPerson(PersonCA pers)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            PersonCA p = em.find(PersonCA.class, pers.getId());
            if(p != null)
            {
                p = pers;
                em.merge(p);
                em.getTransaction().commit();
                return p;
            }
        }
        finally
        {
            em.close();
        }  
        
        return null;
    }
    private HobbyCA HobbyCA() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
    

