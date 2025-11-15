package adapters;

import external_apis.TwitterAPI;
import unified_interface.ISocialMediaAdapter;
import unified_interface.ConteudoUnificado;
import unified_interface.RespostaUnificada;

/**
 * O Adaptador do Twitter.
 * Implementa a interface unificada (Target) e
 * "traduz" as chamadas para a API específica (Adaptee).
 */
public class TwitterAdapter implements ISocialMediaAdapter {

    // 1. O adaptador "tem um" (possui) o adaptee
    private TwitterAPI twitterApi;

    public TwitterAdapter() {
        this.twitterApi = new TwitterAPI(); // Instancia a API externa
    }

    @Override
    public void autenticar(String usuario, String senhaOuToken) {
        // Tradução: "senhaOuToken" no nosso sistema vira "apiKey" no Twitter
        System.out.println("Adaptador (Twitter): Traduzindo autenticação para API Key...");
        this.twitterApi.autenticarComChave(senhaOuToken);
    }

    @Override
    public RespostaUnificada postar(ConteudoUnificado conteudo) {
        // Tradução: Twitter não tem "título", então o adaptador
        // junta o título e o texto.
        System.out.println("Adaptador (Twitter): Traduzindo postagem para Tweet...");
        String tweetTexto = conteudo.getTitulo() + ": " + conteudo.getTexto();
        
        // Chama o método específico do adaptee
        String tweetId = this.twitterApi.tweet(tweetTexto);

        // Tradução (retorno): Traduz a resposta específica (String id)
        // para a nossa RespostaUnificada.
        return new RespostaUnificada("Twitter", tweetId, "https://twitter.com/post/" + tweetId);
    }
}