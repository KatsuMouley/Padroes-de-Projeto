package personagens;

import armas.AdagaSombria; // Importar Adaga
import armas.CajadoArcano;
import strategy.IArma;

public class Mago extends Personagem {

    public Mago(String nome) {
        super(nome, 5, 7, 18, 70, 150);
    }

    @Override
    public boolean podeUsarArma(IArma arma) {
        // ATUALIZADO: Mago pode usar Cajados OU Adagas
        return arma instanceof CajadoArcano || arma instanceof AdagaSombria;
    }

    @Override
    public void aplicarPassivaInicioTurno() {
        this.mana = Math.min(this.manaMaxima, this.mana + 10);
    }
}