// Implementação: Cartão de Crédito
public class PagamentoCartaoCredito implements Pagamento {
    private String numeroCartao;

    public PagamentoCartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    private boolean validarCartao() {
        return numeroCartao != null && numeroCartao.matches("\\d{16}");
    }

    @Override
    public String processarPagamento(double valor) {
        if (validarCartao()) {
            return "Pagamento de R$" + valor + " realizado com Cartão de Crédito.";
        }
        return "Erro: Número do cartão inválido!";
    }
}
