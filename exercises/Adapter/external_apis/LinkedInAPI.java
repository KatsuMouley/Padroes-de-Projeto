package external_apis;

// API 2: LinkedIn (O Adaptee 2)
// Focado em artigos e "updates" profissionais
public class LinkedInAPI {

    public boolean conectar(String usuario, String senha) {
        System.out.println("[LinkedIn] Usuário " + usuario + " conectado.");
        return true;
    }

    // Retorna a URL do post
    public String enviarUpdateProfissional(String titulo, String corpo) {
        String url = "https://linkedin.com/post/" + Math.abs(titulo.hashCode());
        System.out.println("[LinkedIn] Update enviado: '" + titulo + "' (URL: " + url + ")");
        return url;
    }
}