import java.util.Map;
import java.util.HashMap;

/**
 * A classe Singleton que gerencia todas as contas.
 * Usamos a inicialização "Eager" (ansiosa), que é a forma mais simples 
 * e segura em termos de threads de implementar um Singleton em Java.
 */
public class AccountManager {
    
    // 2. A única instância (criada ansiosamente)
    private static final AccountManager instance = new AccountManager();
    
    // Onde guardamos os dados (ID da Conta -> Saldo)
    private Map<String, Double> contas;

    // 1. Construtor privado: impede a instanciação externa
    private AccountManager() {
        contas = new HashMap<>();
        // Mensagem para provar que o construtor só é chamado UMA VEZ.
        System.out.println("[Sistema] Instância do AccountManager criada.");
    }
    
    // 3. Ponto de acesso global: retorna a única instância
    public static AccountManager getInstance() {
        return instance;
    }

    /**
     * Método auxiliar para criar uma conta com saldo inicial.
     * Na nossa simulação, será chamado pelo Construtor do Cliente.
     */
    public void criarConta(String contaId, double saldoInicial) {
        // putIfAbsent garante que não vamos sobrescrever uma conta existente
        contas.putIfAbsent(contaId, saldoInicial);
        System.out.println("[Manager] Conta " + contaId + " criada com saldo: R$ " + saldoInicial);
    }

    // --- Métodos de Operação ---

    public void depositar(String contaId, double valor) {
        if (!contas.containsKey(contaId)) {
            System.out.println("[Manager] Erro: Conta " + contaId + " não encontrada.");
            return;
        }
        if (valor <= 0) {
            System.out.println("[Manager] Erro: O valor do depósito deve ser positivo.");
            return;
        }
        
        double saldoAtual = contas.get(contaId);
        double novoSaldo = saldoAtual + valor;
        contas.put(contaId, novoSaldo);
        System.out.println("[Manager] Depósito de R$" + valor + " em " + contaId + ". Saldo atual: R$ " + novoSaldo);
    }

    public void sacar(String contaId, double valor) {
        if (!contas.containsKey(contaId)) {
            System.out.println("[Manager] Erro: Conta " + contaId + " não encontrada.");
            return;
        }
        if (valor <= 0) {
            System.out.println("[Manager] Erro: O valor do saque deve ser positivo.");
            return;
        }

        double saldoAtual = contas.get(contaId);
        if (saldoAtual >= valor) {
            double novoSaldo = saldoAtual - valor;
            contas.put(contaId, novoSaldo);
            System.out.println("[Manager] Saque de R$" + valor + " de " + contaId + ". Saldo atual: R$ " + novoSaldo);
        } else {
            System.out.println("[Manager] Erro: Saldo insuficiente para sacar R$" + valor + " da conta " + contaId + ". Saldo: R$" + saldoAtual);
        }
    }

    public void verSaldo(String contaId) {
        if (!contas.containsKey(contaId)) {
            System.out.println("[Manager] Erro: Conta " + contaId + " não encontrada.");
            return;
        }
        System.out.println("[Manager] Saldo da conta " + contaId + ": R$ " + contas.get(contaId));
    }

    public void listarContasAtivas() {
        System.out.println("\n--- [Manager] LISTA DE CONTAS ATIVAS ---");
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta registrada.");
        } else {
            // Itera sobre o 'entrySet' para pegar chave e valor
            for (Map.Entry<String, Double> entry : contas.entrySet()) {
                System.out.println("  > Conta ID: " + entry.getKey() + " | Saldo: R$ " + entry.getValue());
            }
        }
        System.out.println("------------------------------------------\n");
    }
}