
package Entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class InfoEntityCA {
    
    @Id
    private int Infoid;
    private String Email;
    
    
    @ManyToOne
   public PhoneCA phoneCA;
    
    @OneToMany(mappedBy = "infoEntityCA")
    private List<AdressCA> adressCAs;
    
    @OneToOne
    private PersonCA personCAs;
   
 
    
    
   
    public InfoEntityCA(){}

    
    public InfoEntityCA(int id, String Email) {
        this.Infoid = id;
        this.Email = Email;
    }


    @Override
    public String toString() {
        return "InfoEntityCA{" + "Infoid=" + Infoid + ", Email=" + Email + '}';
    }

    public int getId() {
        return Infoid;
    }

    public void setId(int id) {
        this.Infoid = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
     public List<AdressCA> addInfoToAdress(AdressCA ac) {
        this.adressCAs.add(ac);
        return adressCAs;
    }
}
