public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int quantidadeTotal;
    private int quantidadeDisponivel;

    public Livro(String titulo, String autor, String isbn, int quantidadeTotal, int quantidadeDisponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeDisponivel = quantidadeTotal;
    }

    public boolean taDisponivel() {
        return quantidadeDisponivel > 0;
    }

    public void emprestar() {
        if (!taDisponivel()) {
            throw new IllegalStateException("Livro Indisponível");
        }
        quantidadeDisponivel--;
    }

    public void devolver() {
        if (quantidadeDisponivel < quantidadeTotal) {
            quantidadeDisponivel++;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

}
