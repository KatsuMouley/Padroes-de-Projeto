package batalha;

import personagens.Personagem;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe Batalha ATUALIZADA
 * Agora suporta 1 Herói contra múltiplos Inimigos.
 */
public class Batalha {
    private Personagem heroi;
    private List<Personagem> inimigos;
    private int turno = 1;

    public Batalha(Personagem heroi, List<Personagem> inimigos) {
        this.heroi = heroi;
        this.inimigos = inimigos;
    }

    public void iniciar() {
        System.out.println("A BATALHA COMEÇOU!");
        System.out.println(heroi + " VS " + inimigos.size() + " inimigos.");
        System.out.println("--------------------");

        while (heroi.estaVivo() && !inimigos.isEmpty()) {
            System.out.println("\n--- TURNO " + turno + " ---");

            // Turno do Herói
            // O herói ataca a lista de inimigos (para o AoE funcionar)
            executarTurno(heroi, inimigos);
            
            // Remove inimigos mortos da lista
            inimigos = inimigos.stream()
                .filter(Personagem::estaVivo)
                .collect(Collectors.toList());

            if (inimigos.isEmpty()) break; // Herói venceu

            // Turno dos Inimigos
            for (Personagem inimigo : inimigos) {
                if (!heroi.estaVivo()) break; // Herói foi derrotado
                // Inimigo ataca o herói (sempre o alvo único)
                executarTurno(inimigo, List.of(heroi)); 
            }
            
            turno++;
        }

        // Resultado
        System.out.println("\n--- FIM DA BATALHA ---");
        if (heroi.estaVivo()) {
            System.out.println(heroi.getNome() + " VENCEU!");
        } else {
            System.out.println("O Herói foi derrotado!");
        }
    }

    // ATUALIZADO: Defensor agora é uma lista
    private void executarTurno(Personagem atacante, List<Personagem> defensores) {
        System.out.println("É a vez de " + atacante.getNome() + ".");
        
        atacante.processarInicioTurno();
        
        if (atacante.getPodeAgir()) {
            // Passa a lista inteira de defensores para o método de ataque
            atacante.executarAtaque(defensores);
        }

        // Imprime o status de todos
        System.out.println(heroi);
        for (Personagem inimigo : inimigos) {
            System.out.println(inimigo);
        }
    }
}