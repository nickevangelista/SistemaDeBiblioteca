import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }
    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }
    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    public void emprestarLivro(String isbn, String usuarioId) {
        Livro livro = buscarLivroPorIsbn(isbn);
        Usuario usuario = buscarUsuarioPorId(usuarioId);

        if (!usuario.podeEmprestar()) {
            throw new IllegalStateException("Usuário bloqueado");
        }

        livro.emprestar(); // já valida disponibilidade

        Emprestimo emprestimo = new Emprestimo(livro, usuario);
        emprestimos.add(emprestimo);
    }
    public void devolverLivro(String isbn, String usuarioId) {
        Emprestimo emprestimo = buscarEmprestimoAtivo(isbn, usuarioId);

        emprestimo.finalizar();
        emprestimo.getLivro().devolver();
    }

    private Livro buscarLivroPorIsbn(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        throw new IllegalArgumentException("Livro não encontrado");
    }
    private Usuario buscarUsuarioPorId(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        throw new IllegalArgumentException("Usuário não encontrado");
    }
    private Emprestimo buscarEmprestimoAtivo(String isbn, String usuarioId) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.estaAtivo()
                    && emprestimo.getLivro().getIsbn().equals(isbn)
                    && emprestimo.getUsuario().getId().equals(usuarioId)) {
                return emprestimo;
            }
        }
        throw new IllegalArgumentException("Empréstimo ativo não encontrado");
    }
    private boolean usuarioExiste(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    private boolean livroExiste(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                return true;
            }
        }
        return false;
    }
    private boolean livroDisponivel(String isbn) {
        Livro livro = buscarLivroPorIsbn(isbn);
        return livro.taDisponivel();
    }




}
