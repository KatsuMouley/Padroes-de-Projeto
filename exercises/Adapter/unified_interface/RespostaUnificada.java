package unified_interface;

// O modelo de dados que nosso sistema usa para RECEBER
// (Cumpre a "Tarefa 2: Sistema de Resposta Unificado")
public class RespostaUnificada {
    private String plataforma;
    private String idPostagem;
    private String urlPostagem;

    public RespostaUnificada(String plataforma, String idPostagem, String urlPostagem) {
        this.plataforma = plataforma;
        this.idPostagem = idPostagem;
        this.urlPostagem = urlPostagem;
    }

    @Override
    public String toString() {
        return String.format("[Resposta Unificada | Plataforma: %s, ID: %s, URL: %s]",
                plataforma, idPostagem, urlPostagem);
    }
}