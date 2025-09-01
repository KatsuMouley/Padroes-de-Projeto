// Factory Cartão de Crédito
public class FactoryCartaoCredito extends PagamentoFactory {
    private String numeroCartao;

    public FactoryCartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public Pagamento criarPagamento() {
        return new PagamentoCartaoCredito(numeroCartao);
    }
}
