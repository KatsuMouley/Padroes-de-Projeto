import batalha.Batalha;
import personagens.*;
import armas.*;
import strategy.IArma;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 1. Criar TODAS as armas (Estratégias)
        IArma espada = new EspadaLonga();
        IArma machado = new MachadoDeGuerra();
        IArma cajado = new CajadoArcano();
        IArma arco = new ArcoElfico();
        IArma adaga = new AdagaSombria();

        // 2. Criar os personagens (Contextos)
        Personagem garen = new Guerreiro("Garen (Herói)");
        Personagem legolas = new Arqueiro("Legolas (Herói)");
        
        Personagem veigar = new Mago("Veigar (Inimigo)");
        Personagem goblin1 = new Guerreiro("Goblin Lanceiro"); // Usando Guerreiro como base
        
        // 3. Equipar as armas (Definir a Estratégia)
        legolas.equiparArma(arco); // Herói usa o Arco
        veigar.equiparArma(cajado);
        goblin1.equiparArma(espada);

        // 4. Teste da Adaga (Primeiro ataque com bônus)
        System.out.println("--- Teste Adaga Sombria ---");
        legolas.equiparArma(adaga); // Troca para a adaga
        // Como o 'veigar' está com 'desprevenido = true', o dano será triplo.
        legolas.executarAtaque(List.of(veigar));
        // Segundo ataque, 'desprevenido = false', dano normal.
        legolas.executarAtaque(List.of(veigar));
        System.out.println("---------------------------\n");


        // 5. Preparar a Batalha (Arqueiro vs Mago e Goblin)
        
        // Resetando a vida do Veigar para a batalha principal
        veigar = new Mago("Veigar (Inimigo)");
        veigar.equiparArma(cajado);
        
        // O herói da batalha
        Personagem heroiBatalha = legolas;
        heroiBatalha.equiparArma(arco); // Equipando o Arco Élfico (AoE)

        // Lista de inimigos
        List<Personagem> inimigos = new ArrayList<>();
        inimigos.add(veigar);
        inimigos.add(goblin1);

        // 6. Iniciar a Batalha
        Batalha arena = new Batalha(heroiBatalha, inimigos);
        arena.iniciar();
    }
}