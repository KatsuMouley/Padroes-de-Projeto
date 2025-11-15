package adapters;

import external_apis.LinkedInAPI;
import unified_interface.ISocialMediaAdapter;
import unified_interface.ConteudoUnificado;
import unified_interface.RespostaUnificada;

/**
 * O Adaptador do LinkedIn.
 * Implementa a mesma interface, mas traduz para uma API diferente.
 */
public class LinkedInAdapter implements ISocialMediaAdapter {

    private LinkedInAPI linkedInApi;

    public LinkedInAdapter() {
        this.linkedInApi = new LinkedInAPI();
    }

    @Override
    public void autenticar(String usuario, String senhaOuToken) {
        // Tradução: O LinkedIn usa usuário e senha
        System.out.println("Adaptador (LinkedIn): Traduzindo autenticação para Usuário/Senha...");
        this.linkedInApi.conectar(usuario, senhaOuToken);
    }

    @Override
    public RespostaUnificada postar(ConteudoUnificado conteudo) {
        // Tradução: LinkedIn usa "título" e "corpo" separadamente
        System.out.println("Adaptador (LinkedIn): Traduzindo postagem para Update Profissional...");
        
        // Chama os métodos específicos do adaptee
        String url = this.linkedInApi.enviarUpdateProfissional(
                conteudo.getTitulo(),
                conteudo.getTexto()
        );

        // Tradução (retorno): Traduz a resposta (String url)
        // para a nossa RespostaUnificada.
        String id = url.substring(url.lastIndexOf('/') + 1);
        return new RespostaUnificada("LinkedIn", id, url);
    }
}