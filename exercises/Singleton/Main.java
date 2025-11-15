public class Main {
    public static void main(String[] args) {
        System.out.println("--- Iniciando Simulação Bancária (Singleton) ---");
        // A mensagem "[Sistema] Instância do AccountManager criada." 
        // deve aparecer apenas UMA VEZ, aqui.
        
        System.out.println("\n--- Criando Clientes ---");
        Cliente clienteA = new Cliente("conta-001", "Alice");
        Cliente clienteB = new Cliente("conta-002", "Bruno");

        System.out.println("\n--- Operações de Alice ---");
        clienteA.fazerDeposito(1500.0);
        clienteA.fazerSaque(300.0);
        clienteA.consultarSaldo();

        System.out.println("\n--- Operações de Bruno ---");
        clienteB.fazerDeposito(500.0);
        clienteB.fazerSaque(800.0); // Tentativa de saque maior que o saldo
        clienteB.consultarSaldo();

        // --- A PROVA DO SINGLETON ---
        System.out.println("\n--- Demonstração do Singleton ---");
        System.out.println("Um 'novo' objeto (outra parte do sistema) vai acessar o Manager...");
        
        // Simulamos outra parte do código pegando o manager
        AccountManager manager = AccountManager.getInstance();
        
        // Se NÃO fosse um Singleton, 'manager' seria uma nova instância
        // com um mapa de contas VAZIO.
        // Como É um Singleton, ele vai listar os saldos de Alice e Bruno.
        
        System.out.println("Listando todas as contas do Manager 'recém-obtido':");
        manager.listarContasAtivas();
        
        // Prova final comparando hash codes
        AccountManager manager2 = AccountManager.getInstance();
        System.out.println("Hashcode Instância 1: " + manager.hashCode());
        System.out.println("Hashcode Instância 2: " + manager2.hashCode());
        
        if(manager.hashCode() == manager2.hashCode()) {
            System.out.println("PROVADO: É a mesma instância!");
        }
    }
}