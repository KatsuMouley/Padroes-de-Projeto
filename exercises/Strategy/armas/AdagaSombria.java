package armas;

import strategy.IArma;
import personagens.Personagem;
import java.util.List;

/**
 * Implementação da Adaga Sombria.
 * Esta arma ataca apenas o primeiro alvo da lista (alvo principal).
 */
public class AdagaSombria implements IArma {

    @Override
    public String getNome() { return "Adaga Sombria"; }

    @Override
    public int getCustoMana() { return 10; }

    @Override
    public boolean podeEquipar(Personagem p) {
        return p.getDestreza() >= 12;
    }

    /**
     * Efeito Especial: "Ataque Furtivo" - Dano triplo se o alvo
     * estiver "desprevenido".
     */
    @Override
    public void atacar(Personagem atacante, List<Personagem> alvos) {
        // Ataques de alvo único afetam apenas o primeiro da lista
        Personagem alvo = alvos.get(0);
        int danoBase = 10;

        // Verifica o status "desprevenido"
        if (alvo.isDesprevenido()) {
            danoBase *= 3; // Dano triplo
            System.out.println(atacante.getNome() + " usa Ataque Furtivo em " + alvo.getNome() + "!");
            System.out.println("  > CRÍTICO! O alvo estava desprevenido! Dano: " + danoBase);
        } else {
            System.out.println(atacante.getNome() + " ataca " + alvo.getNome() + " com " + getNome() + " causando " + danoBase + " de dano.");
        }
        
        alvo.receberDano(danoBase);
        alvo.setDesprevenido(false); // Alvo não está mais desprevenido após ser atacado
    }
}