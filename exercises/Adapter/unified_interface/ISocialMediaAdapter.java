package unified_interface;

/**
 * A interface Target (Alvo).
 * Nosso sistema (GerenciadorMidiaSocial) só usará esta interface.
 * Ela unifica as diferentes formas de postar.
 */
public interface ISocialMediaAdapter {

    /**
     * Autentica o usuário na plataforma.
     */
    void autenticar(String usuario, String senhaOuToken);

    /**
     * Posta o conteúdo na plataforma.
     * @param conteudo O conteúdo a ser postado.
     * @return Uma RespostaUnificada com os dados da postagem.
     */
    RespostaUnificada postar(ConteudoUnificado conteudo);
}