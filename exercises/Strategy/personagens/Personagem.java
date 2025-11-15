package personagens;

import strategy.IArma;
import status.IStatusEffect;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe Contexto (Personagem) ATUALIZADA
 */
public abstract class Personagem {
    protected String nome;
    protected int forca, destreza, inteligencia;
    protected int vida, vidaMaxima;
    protected int mana, manaMaxima;
    protected IArma armaEquipada;
    protected List<IStatusEffect> statusEffects = new ArrayList<>();
    protected boolean podeAgir = true;
    
    // NOVO: Necessário para a Adaga Sombria
    protected boolean desprevenido = true; 

    public Personagem(String nome, int forca, int destreza, int inteligencia, int vida, int mana) {
        this.nome = nome;
        this.forca = forca;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.vidaMaxima = vida;
        this.vida = vida;
        this.manaMaxima = mana;
        this.mana = mana;
    }

    public void equiparArma(IArma arma) {
        if (podeUsarArma(arma) && arma.podeEquipar(this)) {
            this.armaEquipada = arma;
            System.out.println(this.nome + " equipou " + arma.getNome() + ".");
        } else {
            System.out.println(this.nome + " não pode equipar " + arma.getNome() + " (Tipo ou Requisitos inválidos).");
        }
    }

    // ATUALIZADO: Agora passa a lista de alvos
    public void executarAtaque(List<Personagem> alvos) {
        if (armaEquipada == null) {
            System.out.println(nome + " está desarmado e não pode atacar!");
            return;
        }
        if (mana < armaEquipada.getCustoMana()) {
            System.out.println(nome + " não tem mana suficiente para usar " + armaEquipada.getNome() + "!");
            return;
        }

        this.mana -= armaEquipada.getCustoMana();
        // Delega para a arma, passando a lista de alvos
        this.armaEquipada.atacar(this, alvos);
    }

    public abstract boolean podeUsarArma(IArma arma);
    public abstract void aplicarPassivaInicioTurno();

    // --- Gerenciamento de Status e Vida ---

    public void receberDano(int dano) {
        // O dano é aplicado DEPOIS de checar passivas (Esquiva, Pele Dura)
        // nas classes filhas.
        this.vida -= dano;
        if (this.vida < 0) this.vida = 0;
    }

    public void adicionarStatus(IStatusEffect efeito) {
        for (IStatusEffect existente : statusEffects) {
            if (existente.getNome().equals(efeito.getNome())) {
                return;
            }
        }
        this.statusEffects.add(efeito);
    }

    public void processarInicioTurno() {
        this.podeAgir = true; 
        aplicarPassivaInicioTurno();

        Iterator<IStatusEffect> iterator = statusEffects.iterator();
        while (iterator.hasNext()) {
            IStatusEffect efeito = iterator.next();
            efeito.processarTurno(this);
            if (!efeito.estaAtivo()) {
                iterator.remove();
            }
        }
    }

    // --- Getters e Setters ---
    public boolean estaVivo() { return this.vida > 0; }
    public String getNome() { return nome; }
    public int getForca() { return forca; }
    public int getDestreza() { return destreza; } // Necessário para Arqueiro/Adaga
    public int getInteligencia() { return inteligencia; }
    public boolean getPodeAgir() { return podeAgir; }
    public void setPodeAgir(boolean podeAgir) { this.podeAgir = podeAgir; }
    
    // NOVO: Get/Set para Adaga Sombria
    public boolean isDesprevenido() { return desprevenido; }
    public void setDesprevenido(boolean desprevenido) { this.desprevenido = desprevenido; }


    @Override
    public String toString() {
        return String.format("[%s | HP: %d/%d | MP: %d/%d]", nome, vida, vidaMaxima, mana, manaMaxima);
    }
}