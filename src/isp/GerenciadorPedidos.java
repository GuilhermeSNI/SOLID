package isp;

import srp.Pedido;

import java.util.List;

public interface GerenciadorPedidos {
    Pedido criarPedido(String cliente, List<String> itens);
}