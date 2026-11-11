package srp;

import java.util.List;

public class PedidoService {
    private int proximoId = 1;

    public Pedido criar(String cliente, List<String> itens) {
        if (itens == null || itens.isEmpty()) {
            throw new IllegalArgumentException("O pedido precisa ter ao menos um item.");
        }
        return new Pedido(proximoId++, cliente, itens);
    }
}