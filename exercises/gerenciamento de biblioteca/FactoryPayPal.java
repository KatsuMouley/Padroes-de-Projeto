// Factory PayPal

public class FactoryPayPal extends PagamentoFactory {
    private String email;

    public FactoryPayPal(String email) {
        this.email = email;
    }

    @Override
    public Pagamento criarPagamento() {
        return new PagamentoPayPal(email);
    }
}
