package adapters;

import external_apis.InstagramAPI;
import unified_interface.ISocialMediaAdapter;
import unified_interface.ConteudoUnificado;
import unified_interface.RespostaUnificada;

public class InstagramAdapter implements ISocialMediaAdapter {

    private InstagramAPI instagramApi;

    public InstagramAdapter() {
        this.instagramApi = new InstagramAPI();
    }

    @Override
    public void autenticar(String usuario, String senhaOuToken) {
        // Tradução: Instagram usa usuário e senha
        System.out.println("Adaptador (Instagram): Traduzindo autenticação para Usuário/Senha...");
        this.instagramApi.login(usuario, senhaOuToken);
    }

    @Override
    public RespostaUnificada postar(ConteudoUnificado conteudo) {
        // Tradução: O conteúdo unificado será adaptado.
        // O "Texto" vira a legenda. O "Título" é ignorado.
        // O adaptador simula um caminho de imagem, pois nosso
        // ConteudoUnificado não suporta mídias.
        System.out.println("Adaptador (Instagram): Traduzindo postagem para Foto+Legenda...");
        String caminhoSimulado = "caminho/gerado/pelo/app/" + conteudo.getTitulo().hashCode() + ".jpg";
        
        String postId = this.instagramApi.postarFoto(
                caminhoSimulado,
                conteudo.getTexto()
        );

        // Tradução (retorno)
        return new RespostaUnificada("Instagram", postId, "https://instagram.com/p/" + postId);
    }
}