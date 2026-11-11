package isp;

import srp.Pedido;

public interface GerenciadorEntregas {
    void entregar(Pedido pedido, String entregador);
}