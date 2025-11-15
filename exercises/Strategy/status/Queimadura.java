package status;

import personagens.Personagem;

public class Queimadura implements IStatusEffect {
    private int duracao = 2;

    @Override
    public String getNome() { return "Queimadura"; }

    @Override
    public int getDuracao() { return duracao; }

    @Override
    public boolean estaAtivo() { return duracao > 0; }

    @Override
    public void processarTurno(Personagem alvo) {
        if (estaAtivo()) {
            System.out.println("  > " + alvo.getNome() + " sofre 10 de dano de queimadura.");
            alvo.receberDano(10); // Dano de 10 por turno
            duracao--;
        }
    }
}