package cst438a8f.data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("cst438a8fPU");
    
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}