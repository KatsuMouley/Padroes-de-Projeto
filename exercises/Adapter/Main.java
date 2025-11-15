import client.GerenciadorMidiaSocial;
import adapters.TwitterAdapter;
import adapters.LinkedInAdapter;
import adapters.InstagramAdapter;
import adapters.TikTokAdapter;
import unified_interface.ConteudoUnificado;

public class Main {
    public static void main(String[] args) {
        
        // 1. Cria o nosso sistema
        GerenciadorMidiaSocial gerenciador = new GerenciadorMidiaSocial();

        // 2. Cria os adaptadores para as 4 APIs incompatíveis
        TwitterAdapter adaptadorTwitter = new TwitterAdapter();
        LinkedInAdapter adaptadorLinkedIn = new LinkedInAdapter();
        InstagramAdapter adaptadorInstagram = new InstagramAdapter();
        TikTokAdapter adaptadorTikTok = new TikTokAdapter();

        // 3. Adiciona os adaptadores (e não as APIs!) ao nosso sistema
        System.out.println("--- Configurando Plataformas ---");
        gerenciador.adicionarPlataforma(adaptadorTwitter);
        gerenciador.adicionarPlataforma(adaptadorLinkedIn);
        gerenciador.adicionarPlataforma(adaptadorInstagram);
        gerenciador.adicionarPlataforma(adaptadorTikTok);
        
        // 4. Cria o conteúdo unificado
        ConteudoUnificado postagem = new ConteudoUnificado(
                "Design Patterns",
                "Adapter é incrível para integrar APIs legadas!"
        );

        // 5. Manda o gerenciador postar (ele cuidará da tradução)
        gerenciador.postarEmTudo(postagem);
    }
}