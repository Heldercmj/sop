import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {

    private static final String PERSISTENCE_UNIT_NAME = "ControleFinanceiroSOPPU"; // Nome da unidade de persistência definido no arquivo persistence.xml
    private static EntityManagerFactory entityManagerFactory;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inicializar a fábrica de EntityManager.", e);
        }
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
