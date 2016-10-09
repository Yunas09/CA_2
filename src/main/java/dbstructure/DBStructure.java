
package dbstructure;

import java.util.HashMap;
import javax.persistence.Persistence;





public class DBStructure {
       public static void main(String[] args)
    {
        HashMap<String, Object> puproperties = new HashMap();
        
        puproperties.put("javax.persistence.sql-load-script-source", "scripts/ClearDB.sql");
        
        Persistence.generateSchema("CA_2", puproperties);
        
        Persistence.generateSchema("CA_2", null);
    }
}
