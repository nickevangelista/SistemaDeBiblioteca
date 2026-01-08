// É um main pra testar as classes
public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Livro livro1 = new Livro(
                "Clean Code",
                "Robert C. Martin",
                "ISBN-001",
                2,
                2
        );

        Livro livro2 = new Livro(
                "Effective Java",
                "Joshua Bloch",
                "ISBN-002",
                1,
                1
        );

        Usuario usuario1 = new Usuario("U1", "Alice", false);
        Usuario usuario2 = new Usuario("U2", "Bob", false);

        biblioteca.cadastrarLivro(livro1);
        biblioteca.cadastrarLivro(livro2);

        biblioteca.cadastrarUsuario(usuario1);
        biblioteca.cadastrarUsuario(usuario2);

        biblioteca.emprestarLivro("ISBN-001", "U1");
        System.out.println("Livro emprestado para Alice");

        biblioteca.emprestarLivro("ISBN-001", "U2");
        System.out.println("Livro emprestado para Bob");

        biblioteca.devolverLivro("ISBN-001", "U1");
        System.out.println("Livro devolvido por Alice");
    }
}
