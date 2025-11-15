package personagens;

import armas.ArcoElfico;
import armas.AdagaSombria;
import strategy.IArma;

public class Arqueiro extends Personagem {

    public Arqueiro(String nome) {
        super(nome, 8, 15, 7, 90, 80);
    }

    @Override
    public boolean podeUsarArma(IArma arma) {
        // Arqueiro pode usar Arcos ou Adagas
        return arma instanceof ArcoElfico || arma instanceof AdagaSombria;
    }

    @Override
    public void aplicarPassivaInicioTurno() {
        // Nenhuma passiva ativa no início do turno
    }

    @Override
    public void receberDano(int dano) {
        // Passiva: "Esquiva" - 25% de chance de evitar o ataque
        if (Math.random() < 0.25) {
            System.out.println("  > " + getNome() + " se esquivou do ataque!");
            return; // Evita o dano
        }
        // Se não esquivou, recebe o dano normalmente
        super.receberDano(dano);
    }
}