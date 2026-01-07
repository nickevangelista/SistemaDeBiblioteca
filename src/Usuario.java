public class Usuario {
    private String id;
    private String nome;
    private boolean bloqueado;

    public Usuario(String id, String nome, boolean bloqueado) {
        this.id = id;
        this.nome = nome;
        this.bloqueado = false;
    }
    public boolean podeEmprestar() {
        return !bloqueado;
    }

    public void bloquear() {
        this.bloqueado = true;
    }

    public void desbloquear() {
        this.bloqueado = false;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}