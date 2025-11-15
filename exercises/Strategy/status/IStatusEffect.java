package status;

import personagens.Personagem;

/**
 * Interface para Efeitos de Status (Sangramento, Queimadura, etc.)
 * Permite aplicar o Princípio Aberto/Fechado (OCP): podemos adicionar
 * novos status sem modificar a classe Personagem.
 */
public interface IStatusEffect {
    String getNome();
    int getDuracao();
    boolean estaAtivo();
    
    /**
     * Processa o efeito no início do turno do personagem afetado.
     * @param alvo O personagem sofrendo o efeito.
     */
    void processarTurno(Personagem alvo);
}