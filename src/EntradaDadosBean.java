import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class EntradaDadosBean {
        private String numeroProtocoloDespesa;
        private String tipoDespesa;
        private String dataProtocolo;
        private String dataVencimento;
        private String credorDespesa;
        private String descricaoDespesa;
        private String valorDespesa;

        private String anoEmpenho;
        private String numeroEmpenho;
        private String dataEmpenho;
        private String valorEmpenho;
        private String observacaoEmpenho;

        private String anoPagamento;
        private String numeroPagamento;
        private String dataPagamento;
        private String valorPagamento;
        private String observacaoPagamento;

        public void salvarDespesa() {
                // Lógica para salvar os dados da Despesa
        }

        public void salvarEmpenho() {
                // Lógica para salvar os dados do Empenho
        }

        public void salvarPagamento() {
                // Lógica para salvar os dados do Pagamento
        }

        // Getters e setters para todos os atributos

}
