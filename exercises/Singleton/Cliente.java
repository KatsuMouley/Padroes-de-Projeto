/**
 * Representa um cliente do banco.
 * O cliente usa o AccountManager para realizar suas operações.
 */
public class Cliente {
    private String clienteId;
    private String nome;

    public Cliente(String clienteId, String nome) {
        this.clienteId = clienteId;
        this.nome = nome;
        
        // Ao criar um novo cliente, automaticamente criamos sua conta 
        // no AccountManager com saldo inicial zero.
        AccountManager.getInstance().criarConta(this.clienteId, 0.0);
    }

    // --- Operações do Cliente ---
    // O cliente DELEGA as operações para o AccountManager

    public void fazerDeposito(double valor) {
        System.out.println(this.nome + " (ID: " + this.clienteId + ") está tentando depositar R$" + valor);
        AccountManager.getInstance().depositar(this.clienteId, valor);
    }

    public void fazerSaque(double valor) {
        System.out.println(this.nome + " (ID: " + this.clienteId + ") está tentando sacar R$" + valor);
        AccountManager.getInstance().sacar(this.clienteId, valor);
    }

    public void consultarSaldo() {
        System.out.println(this.nome + " (ID: " + this.clienteId + ") está consultando o saldo.");
        AccountManager.getInstance().verSaldo(this.clienteId);
    }
    
    public String getNome() {
        return nome;
    }
}