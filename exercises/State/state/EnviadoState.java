package state;

import context.Order;

// 3. Estado: Enviado
public class EnviadoState extends BaseState {

    @Override
    public void entregar(Order order) {
        System.out.println("Ação: Entrega confirmada pelo cliente.");
        // Transição: Muda o estado para "Entregue"
        order.setState(new EntregueState());
    }
    
    // Nota: Cancelar um pedido já enviado geralmente não é permitido
    // ou seguiria um fluxo de "devolução", mas para este exemplo,
    // usamos o BaseState que já define 'cancelar' como inválido.
}