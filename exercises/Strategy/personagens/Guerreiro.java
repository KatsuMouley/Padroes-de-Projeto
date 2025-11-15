package personagens;

import armas.EspadaLonga;
import armas.MachadoDeGuerra;
import strategy.IArma;
import armas.ArcoElfico;
import armas.AdagaSombria;

public class Guerreiro extends Personagem {

    public Guerreiro(String nome) {
        super(nome, 15, 8, 5, 120, 50);
    }

    @Override
    public boolean podeUsarArma(IArma arma) {
        // Guerreiro só pode usar Espadas ou Machados
        // (Ele não pode usar ArcoElfico ou AdagaSombria)
        return arma instanceof EspadaLonga || arma instanceof MachadoDeGuerra;
    }

    @Override
    public void aplicarPassivaInicioTurno() {
        // Passiva "Pele Dura" é aplicada no método receberDano
    }

    @Override
    public void receberDano(int dano) {
        // Passiva: "Pele Dura" - Reduz dano recebido em 20%
        int danoReduzido = (int) (dano * 0.80);
        System.out.println("  > Pele Dura! Dano reduzido para " + danoReduzido);
        super.receberDano(danoReduzido);
    }
}