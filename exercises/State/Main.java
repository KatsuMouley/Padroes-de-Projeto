import context.Order;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("--- Cenário 1: Caminho Feliz (Completo) ---");
        Order order1 = new Order("1001"); // Estado: Novo
        order1.enviar();    // Inválido (Novo -> Enviar)
        order1.pagar();     // Válido   (Novo -> Pago)
        order1.pagar();     // Inválido (Pago -> Pagar)
        order1.enviar();    // Válido   (Pago -> Enviado)
        order1.entregar();  // Válido   (Enviado -> Entregue)
        order1.cancelar();  // Inválido (Entregue -> Cancelar)

        System.out.println("\n--- Cenário 2: Cancelamento (Pós-Pagamento) ---");
        Order order2 = new Order("1002"); // Estado: Novo
        order2.pagar();     // Válido   (Novo -> Pago)
        order2.cancelar();  // Válido   (Pago -> Cancelado)
        order2.enviar();    // Inválido (Cancelado -> Enviar)

        System.out.println("\n--- Cenário 3: Cancelamento (Antes do Pagamento) ---");
        Order order3 = new Order("1003"); // Estado: Novo
        order3.cancelar();  // Válido   (Novo -> Cancelado)
    }
}