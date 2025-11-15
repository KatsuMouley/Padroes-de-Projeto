package external_apis;

// API 1: Twitter (O Adaptee 1)
// Focada em texto curto (tweets)
public class TwitterAPI {
    
    public void autenticarComChave(String apiKey) {
        System.out.println("[Twitter] Autenticado com API Key: " + apiKey.substring(0, 5) + "...");
    }

    // Retorna o ID do Tweet
    public String tweet(String texto) {
        String tweetId = String.valueOf(Math.abs(texto.hashCode()));
        System.out.println("[Twitter] Tweet enviado: '" + texto + "' (ID: " + tweetId + ")");
        return tweetId;
    }
}