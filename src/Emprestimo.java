import java.time.LocalDate;
public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = null;
    }
    public boolean estaAtivo() {
        return dataDevolucao == null;
    }
    public void finalizar() {
        if  (!estaAtivo()) {
            throw new IllegalStateException("Empréstimo Já finalizado");
        }
    }
    public Livro getLivro() {
        return livro;
    }
    public Usuario getUsuario() {
        return usuario;
    }
}
