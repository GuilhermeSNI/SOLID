package srp;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {
    private final List<Pedido> pedidos = new ArrayList<>();

    public void salvar(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> listarTodos() { return List.copyOf(pedidos); }
}

