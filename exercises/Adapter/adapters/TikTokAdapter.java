package adapters;

import external_apis.TikTokAPI;
import unified_interface.ISocialMediaAdapter;
import unified_interface.ConteudoUnificado;
import unified_interface.RespostaUnificada;

public class TikTokAdapter implements ISocialMediaAdapter {

    private TikTokAPI tikTokApi;

    public TikTokAdapter() {
        this.tikTokApi = new TikTokAPI();
    }

    @Override
    public void autenticar(String usuario, String senhaOuToken) {
        // Tradução: TikTok usa token
        System.out.println("Adaptador (TikTok): Traduzindo autenticação para Token...");
        this.tikTokApi.autenticarToken(senhaOuToken);
    }

    @Override
    public RespostaUnificada postar(ConteudoUnificado conteudo) {
        // Tradução: Vamos adaptar nosso conteúdo unificado
        // O "Título" vira o "Som"
        // O "Texto" vira as "Hashtags" (simulando um split)
        System.out.println("Adaptador (TikTok): Traduzindo postagem para Vídeo+Som+Hashtags...");
        String caminhoVideoSimulado = "video/gerado/" + conteudo.getTitulo().hashCode() + ".mp4";
        String[] hashtags = { "#" + conteudo.getTexto().split(" ")[0] }; // Pega a primeira palavra

        String videoUrl = this.tikTokApi.uploadVideo(
                caminhoVideoSimulado,
                conteudo.getTitulo(), // Título vira o Som
                hashtags               // Texto vira as Hashtags
        );
        
        String videoId = videoUrl.substring(videoUrl.lastIndexOf('/') + 1);
        return new RespostaUnificada("TikTok", videoId, videoUrl);
    }
}