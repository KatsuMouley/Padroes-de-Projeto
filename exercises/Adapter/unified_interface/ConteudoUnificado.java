package unified_interface;

// O modelo de dados que nosso sistema usa para ENVIAR
public class ConteudoUnificado {
    private String titulo;
    private String texto;
    // Poderia ter midia, etc.

    public ConteudoUnificado(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    public String getTitulo() { return titulo; }
    public String getTexto() { return texto; }
}