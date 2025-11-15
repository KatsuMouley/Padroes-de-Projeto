package status;

import personagens.Personagem;

public class Sangramento implements IStatusEffect {
    private int duracao = 3;

    @Override
    public String getNome() { return "Sangramento"; }

    @Override
    public int getDuracao() { return duracao; }

    @Override
    public boolean estaAtivo() { return duracao > 0; }

    @Override
    public void processarTurno(Personagem alvo) {
        if (estaAtivo()) {
            System.out.println("  > " + alvo.getNome() + " sofre 5 de dano de sangramento.");
            alvo.receberDano(5); // Dano de 5 por turno
            duracao--;
        }
    }
}