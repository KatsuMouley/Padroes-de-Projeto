package exercises.exercise3;
// Implementação: PayPal
public class PagamentoPayPal implements Pagamento {
    private String email;

    public PagamentoPayPal(String email) {
        this.email = email;
    }

    private boolean validarContaPayPal() {
        return email != null && email.contains("@") && email.endsWith(".com");
    }

    @Override
    public String processarPagamento(double valor) {
        if (validarContaPayPal()) {
            return "Pagamento de R$" + valor + " realizado com PayPal.";
        }
        return "Erro: Conta PayPal inválida!";
    }
}
