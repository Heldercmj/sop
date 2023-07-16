import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class UsuarioDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvar(Usuario usuario) {
        entityManager.persist(usuario);
    }

    public List<Usuario> listar() {
        return entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }

    // outros métodos para atualizar e excluir usuários
}
