import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class ConsultaDespesasBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dataProtocolo;
    private String tipoDespesa;
    private String credor;
    private List<Despesa> despesas;

    @PostConstruct
    public void init() {
        consultarDespesas(); // Realiza a consulta ao carregar a página
    }

    public void consultarDespesas() {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        try {
            String jpql = "SELECT d FROM Despesa d WHERE 1 = 1";

            if (dataProtocolo != null && !dataProtocolo.isEmpty()) {
                jpql += " AND d.dataProtocolo = :dataProtocolo";
            }

            if (tipoDespesa != null && !tipoDespesa.isEmpty()) {
                jpql += " AND d.tipoDespesa = :tipoDespesa";
            }

            if (credor != null && !credor.isEmpty()) {
                jpql += " AND d.credor = :credor";
            }

            TypedQuery<Despesa> query = entityManager.createQuery(jpql, Despesa.class);

            if (dataProtocolo != null && !dataProtocolo.isEmpty()) {
                query.setParameter("dataProtocolo", dataProtocolo);
            }

            if (tipoDespesa != null && !tipoDespesa.isEmpty()) {
                query.setParameter("tipoDespesa", tipoDespesa);
            }

            if (credor != null && !credor.isEmpty()) {
                query.setParameter("credor", credor);
            }

            despesas = query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    // Getters e Setters

    public String getDataProtocolo() {
        return dataProtocolo;
    }

    public void setDataProtocolo(String dataProtocolo) {
        this.dataProtocolo = dataProtocolo;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public String getCredor() {
        return credor;
    }

    public void setCredor(String credor) {
        this.credor = credor;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }
}
