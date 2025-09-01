// Classe Main para testar
public class Main {
    public static void main(String[] args) {
        PagamentoService service = new PagamentoService();

        // Cartão de Crédito
        service.processarPagamento(new FactoryCartaoCredito("1234567812345678"), 150.00);

        // PayPal
        service.processarPagamento(new FactoryPayPal("usuario@teste.com"), 75.00);

        // Criptomoeda
        service.processarPagamento(new FactoryCriptomoeda(500.00), 300.00);

        // Testando erro de cartão inválido
        service.processarPagamento(new FactoryCartaoCredito("1234"), 50.00);

        // Testando erro de saldo insuficiente
        service.processarPagamento(new FactoryCriptomoeda(100.00), 200.00);
    }
}
