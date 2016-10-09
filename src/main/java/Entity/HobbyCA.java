package Entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class HobbyCA {

    @Id 
    private String hobbyName;
    private String hobbyDesc;
    
    
    @ManyToMany(mappedBy = "hobbyCAs")
    private List<PersonCA> personCAs;
    
   public HobbyCA(){}
    
    public HobbyCA(String hobbyName, String hobbyDesc) {
        this.hobbyName = hobbyName;
        this.hobbyDesc = hobbyDesc;
       
    }

    
    
     @Override
    public String toString() {
        return "HobbyCA{, hobbyName=" + hobbyName + ", hobbyDesc=" + hobbyDesc +  '}';
    }
  
    
   
    
    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public String getHobbyDesc() {
        return hobbyDesc;
    }

    public void setHobbyDesc(String hobbyDesc) {
        this.hobbyDesc = hobbyDesc;
    }
    
    public List<PersonCA> addHobbyToPerson(PersonCA ps) {
        this.personCAs.add(ps);
        return personCAs;
    }

}
