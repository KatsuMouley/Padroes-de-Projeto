package armas;

import strategy.IArma;
import personagens.Personagem;
import java.util.List;

/**
 * Implementação do Arco Élfico.
 * Esta arma REQUER que o método atacar receba uma Lista de alvos,
 * pois seu efeito é em área.
 */
public class ArcoElfico implements IArma {

    @Override
    public String getNome() { return "Arco Élfico"; }

    @Override
    public int getCustoMana() { return 15; }

    @Override
    public boolean podeEquipar(Personagem p) {
        return p.getDestreza() >= 8;
    }

    /**
     * Efeito Especial: "Chuva de Flechas" - Atinge todos os alvos na lista.
     */
    @Override
    public void atacar(Personagem atacante, List<Personagem> alvos) {
        int danoBase = 12;
        System.out.println(atacante.getNome() + " usa Chuva de Flechas!");

        // Itera sobre TODOS os alvos e aplica o dano
        for (Personagem alvo : alvos) {
            System.out.println("  > " + alvo.getNome() + " é atingido e sofre " + danoBase + " de dano.");
            alvo.receberDano(danoBase);
        }
    }
}