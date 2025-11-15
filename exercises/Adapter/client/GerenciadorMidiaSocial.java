package client;

import unified_interface.ISocialMediaAdapter;
import unified_interface.ConteudoUnificado;
import unified_interface.RespostaUnificada;
import java.util.List;
import java.util.ArrayList;

/**
 * O Cliente (Client).
 * Esta classe usa a interface unificada (Target) e
 * não tem NENHUMA dependência das APIs externas.
 */
public class GerenciadorMidiaSocial {

    // O gerenciador opera sobre uma lista de adaptadores
    private List<ISocialMediaAdapter> plataformas;

    public GerenciadorMidiaSocial() {
        this.plataformas = new ArrayList<>();
    }

    // Adiciona uma nova plataforma (adaptada)
    public void adicionarPlataforma(ISocialMediaAdapter plataforma) {
        // Autenticação genérica (exemplo)
        plataforma.autenticar("meuUsuario", "minhaSenhaSuperSegura123");
        this.plataformas.add(plataforma);
        System.out.println("Plataforma adicionada ao gerenciador.");
    }

    // O método principal do nosso sistema
    public void postarEmTudo(ConteudoUnificado conteudo) {
        System.out.println("\n--- [Gerenciador] AGENDANDO POSTAGEM ---");
        System.out.println("Conteúdo: " + conteudo.getTitulo());
        
        if (plataformas.isEmpty()) {
            System.out.println("[Gerenciador] Nenhuma plataforma configurada.");
            return;
        }

        for (ISocialMediaAdapter adaptador : plataformas) {
            // O cliente simplesmente chama o método unificado "postar"
            // Ele NÃO SABE se está chamando "tweet" ou "enviarUpdate"
            RespostaUnificada resposta = adaptador.postar(conteudo);
            System.out.println("[Gerenciador] Sucesso! Resposta: " + resposta);
        }
        
        System.out.println("--- [Gerenciador] POSTAGEM CONCLUÍDA ---");
    }
}