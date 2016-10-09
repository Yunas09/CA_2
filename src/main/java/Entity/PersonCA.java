
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class PersonCA implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;    
    private String firstName;
    private String lastName;
    
    
    
    @ManyToMany
    private List<HobbyCA> hobbyCAs;
    
    
    @OneToOne(mappedBy = "personCAs")
   private List<InfoEntityCA> infoEntityCAs;
        
    public PersonCA()
    {
    }

    public PersonCA(String firstName, String lastName,List<HobbyCA> hobbies)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobbyCAs = hobbies;
    }

    @Override
    public String toString() {
        return "PersonCA{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", hobbyCAs=" + hobbyCAs + '}';
    }

   

    public int getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }  
    
    public List<InfoEntityCA> addInfoToPerson(InfoEntityCA ps) {
        this.infoEntityCAs.add(ps);
        return infoEntityCAs;
    }
 
}

