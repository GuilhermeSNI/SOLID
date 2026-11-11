package srp;

public class PedidoView {
    public void exibir(Pedido pedido) {
        System.out.println("Pedido #" + pedido.getId());
        System.out.println("Cliente: " + pedido.getCliente());
        System.out.println("Itens: " + String.join(", ", pedido.getItens()));
    }
}

