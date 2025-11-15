package state;

import context.Order;

// 1. Estado: Novo
public class NovoState extends BaseState {

    @Override
    public void pagar(Order order) {
        System.out.println("Ação: Pagamento recebido.");
        // Transição: Muda o estado do pedido para "Pago"
        order.setState(new PagoState());
    }

    @Override
    public void cancelar(Order order) {
        System.out.println("Ação: Pedido cancelado.");
        // Transição: Muda o estado do pedido para "Cancelado"
        order.setState(new CanceladoState());
    }
}