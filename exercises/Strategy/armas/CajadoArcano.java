package armas;

import strategy.IArma;
import personagens.Personagem;
import status.Queimadura;
import java.util.List; // Importar List

public class CajadoArcano implements IArma {

    @Override
    public String getNome() { return "Cajado Arcano"; }

    @Override
    public int getCustoMana() { return 25; }

    @Override
    public boolean podeEquipar(Personagem p) {
        return p.getInteligencia() >= 12;
    }

    // ATUALIZADO: Recebe List<Personagem> alvos
    @Override
    public void atacar(Personagem atacante, List<Personagem> alvos) {
        // Pega o primeiro alvo da lista (alvo principal)
        Personagem alvo = alvos.get(0);

        int danoBase = 8;
        System.out.println(atacante.getNome() + " conjura Bola de Fogo em " + alvo.getNome() + " causando " + danoBase + " de dano.");
        alvo.receberDano(danoBase);
        alvo.setDesprevenido(false); // Não está mais desprevenido

        // Efeito Especial: Causa queimadura
        System.out.println("  > " + alvo.getNome() + " está em chamas!");
        alvo.adicionarStatus(new Queimadura());
    }
}