// Serviço que usa o Factory Method
public class PagamentoService {
    public void processarPagamento(PagamentoFactory factory, double valor) {
        Pagamento pagamento = factory.criarPagamento();
        String resultado = pagamento.processarPagamento(valor);
        System.out.println(resultado);
    }
}
