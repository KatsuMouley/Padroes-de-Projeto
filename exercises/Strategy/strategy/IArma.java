package strategy;

import personagens.Personagem;
import java.util.List; // Importar List

/**
 * Interface Strategy (IArma) ATUALIZADA
 * O método atacar agora recebe uma LISTA de alvos.
 * Isso é necessário para o "Arco Élfico" (ataque em área).
 * Armas de alvo-único simplesmente atacarão o índice 0 da lista.
 */
public interface IArma {

    /**
     * Aplica o ataque da arma.
     * @param atacante O personagem que está usando a arma.
     * @param alvos A lista de todos os oponentes válidos.
     */
    void atacar(Personagem atacante, List<Personagem> alvos);

    // Métodos de verificação e informação
    boolean podeEquipar(Personagem personagem);
    int getCustoMana();
    String getNome();
}