package external_apis;

// API 3: Instagram (O Adaptee 3)
// Focado em imagem + legenda.
public class InstagramAPI {

    public boolean login(String usuario, String senha) {
        System.out.println("[Instagram] Usuário " + usuario + " logado com senha.");
        return true;
    }

    // Retorna um ID de postagem
    public String postarFoto(String caminhoImagem, String legenda) {
        String postId = "IG" + Math.abs(caminhoImagem.hashCode());
        System.out.println("[Instagram] Foto postada: " + caminhoImagem);
        System.out.println("[Instagram] Legenda: '" + legenda + "' (ID: " + postId + ")");
        return postId;
    }
}