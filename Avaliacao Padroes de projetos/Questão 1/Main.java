

import com.empresa.risco.context.ProcessadorRisco;
import com.empresa.risco.data.ContextoRisco;
import com.empresa.risco.strategy.ExpectedShortfallStrategy;
import com.empresa.risco.strategy.StressTestingStrategy;
import com.empresa.risco.strategy.ValueAtRiskStrategy;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Criação do "contexto complexo" com parâmetros financeiros
        Map<String, Double> ativos = new HashMap<>();
        ativos.put("PETR4", 100000.0);
        ativos.put("VALE3", 150000.0);

        ContextoRisco contexto = new ContextoRisco(
                250000.00, // valorPortifolio
                0.15, // taxaVolatilidade
                "Crise Hídrica", // cenarioEconomico
                ativos);

        // 1. O cliente (main) inicia o processador com uma estratégia padrão (VaR)
        ProcessadorRisco processador = new ProcessadorRisco(new ValueAtRiskStrategy());

        System.out.println("Executando primeira análise (Padrão: VaR):");
        processador.executarAnalise(contexto);

        // 2. O cliente troca o algoritmo em tempo de execução para Expected Shortfall
        // (Atende ao requisito: "intercambiável em tempo de execução")
        processador.setAlgoritmo(new ExpectedShortfallStrategy());
        System.out.println("Executando segunda análise (Estratégia: ES):");
        processador.executarAnalise(contexto);

        // 3. O cliente troca novamente, agora para Stress Testing
        // (O cliente não conhece os detalhes de implementação, apenas a interface)
        processador.setAlgoritmo(new StressTestingStrategy());
        System.out.println("Executando terceira análise (Estratégia: Stress Test):");
        processador.executarAnalise(contexto);
    }
}