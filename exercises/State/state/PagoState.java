package state;

import context.Order;

// 2. Estado: Pago
public class PagoState extends BaseState {

    @Override
    public void enviar(Order order) {
        System.out.println("Ação: Pedido enviado para o cliente.");
        // Transição: Muda o estado para "Enviado"
        order.setState(new EnviadoState());
    }

    @Override
    public void cancelar(Order order) {
        System.out.println("Ação: Pedido (já pago) cancelado. Iniciando reembolso.");
        // Transição: Muda o estado para "Cancelado"
        order.setState(new CanceladoState());
    }
}