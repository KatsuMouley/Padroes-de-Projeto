package external_apis;

// API 4: TikTok (O Adaptee 4)
// Focado em vídeo, som e hashtags.
public class TikTokAPI {

    public void autenticarToken(String token) {
        System.out.println("[TikTok] Autenticado com Token: " + token.substring(0, 8) + "...");
    }

    // Retorna a URL do vídeo
    public String uploadVideo(String caminhoVideo, String som, String[] hashtags) {
        String videoUrl = "https://tiktok.com/v/" + Math.abs(caminhoVideo.hashCode());
        System.out.println("[TikTok] Vídeo enviado: " + caminhoVideo);
        System.out.println("[TikTok] Som: " + som + " | Hashtags: " + String.join(", ", hashtags));
        return videoUrl;
    }
}