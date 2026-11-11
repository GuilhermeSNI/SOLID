package isp;

import srp.Pedido;

public class GestaoEntregas implements GerenciadorEntregas {
    @Override
    public void entregar(Pedido pedido, String entregador) {
        System.out.println("Pedido #" + pedido.getId() + " entregue por " + entregador + ".");
    }
}