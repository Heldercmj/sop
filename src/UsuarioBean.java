import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {
    private String nome;
    private String email;
    private List<Usuario> usuarios;

    @Inject
    private UsuarioDAO usuarioDAO;

    @PostConstruct
    public void init() {
        usuarios = usuarioDAO.listar();
    }

    public void salvar() {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuarioDAO.salvar(usuario);
        usuarios = usuarioDAO.listar();
        // Limpar os campos de entrada após salvar
        nome = null;
        email = null;
    }

    // getters e setters
}
