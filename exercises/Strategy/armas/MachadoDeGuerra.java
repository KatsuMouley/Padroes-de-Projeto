package armas;

import strategy.IArma;
import personagens.Personagem;
import status.Atordoado;
import java.util.List; // Importar List

public class MachadoDeGuerra implements IArma {

    @Override
    public String getNome() { return "Machado de Guerra"; }

    @Override
    public int getCustoMana() { return 5; }

    @Override
    public boolean podeEquipar(Personagem p) {
        return p.getForca() >= 15;
    }

    // ATUALIZADO: Recebe List<Personagem> alvos
    @Override
    public void atacar(Personagem atacante, List<Personagem> alvos) {
        // Pega o primeiro alvo da lista (alvo principal)
        Personagem alvo = alvos.get(0);
        
        int danoBase = 18;
        System.out.println(atacante.getNome() + " esmaga " + alvo.getNome() + " com " + getNome() + " causando " + danoBase + " de dano.");
        alvo.receberDano(danoBase);
        alvo.setDesprevenido(false); // Não está mais desprevenido

        // Efeito Especial: 25% de chance de atordoar
        if (Math.random() < 0.25) {
            System.out.println("  > " + alvo.getNome() + " foi atordoado!");
            alvo.adicionarStatus(new Atordoado());
        }
    }
}