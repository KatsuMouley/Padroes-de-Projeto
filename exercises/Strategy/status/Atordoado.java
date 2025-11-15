package status;

import personagens.Personagem;

public class Atordoado implements IStatusEffect {
    private int duracao = 1; // Atordoa por 1 turno

    @Override
    public String getNome() { return "Atordoado"; }

    @Override
    public int getDuracao() { return duracao; }

    @Override
    public boolean estaAtivo() { return duracao > 0; }

    @Override
    public void processarTurno(Personagem alvo) {
        if (estaAtivo()) {
            // A lógica de "perder o turno" é tratada na classe Batalha
            // Aqui, apenas controlamos a duração.
            System.out.println("  > " + alvo.getNome() + " está atordoado e não pode agir!");
            alvo.setPodeAgir(false);
            duracao--;
        }
    }
}