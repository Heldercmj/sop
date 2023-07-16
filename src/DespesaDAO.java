import javax.persistence.EntityManager;

public class DespesaDAO {

    public void salvarDespesa(Despesa despesa) {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(despesa);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Erro ao salvar a despesa.", e);
        } finally {
            entityManager.close();
        }
    }
}
