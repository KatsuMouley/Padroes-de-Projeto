package armas;

import strategy.IArma;
import personagens.Personagem;
import status.Sangramento;
import java.util.List; // Importar List

public class EspadaLonga implements IArma {

    @Override
    public String getNome() { return "Espada Longa"; }

    @Override
    public int getCustoMana() { return 0; }

    @Override
    public boolean podeEquipar(Personagem p) {
        return p.getForca() >= 10;
    }

    // ATUALIZADO: Recebe List<Personagem> alvos
    @Override
    public void atacar(Personagem atacante, List<Personagem> alvos) {
        // Pega o primeiro alvo da lista (alvo principal)
        Personagem alvo = alvos.get(0); 
        
        int danoBase = 15;
        System.out.println(atacante.getNome() + " ataca " + alvo.getNome() + " com " + getNome() + " causando " + danoBase + " de dano.");
        alvo.receberDano(danoBase);
        alvo.setDesprevenido(false); // Não está mais desprevenido

        // Efeito Especial: 30% de chance de sangramento
        if (Math.random() < 0.30) {
            System.out.println("  > " + alvo.getNome() + " está sangrando!");
            alvo.adicionarStatus(new Sangramento());
        }
    }
}