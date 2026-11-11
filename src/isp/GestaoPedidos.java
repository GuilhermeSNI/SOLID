package isp;

import srp.Pedido;
import srp.PedidoRepository;
import srp.PedidoService;
import java.util.List;

public class GestaoPedidos implements GerenciadorPedidos {
    private final PedidoService service;
    private final PedidoRepository repository;

    public GestaoPedidos(PedidoService service, PedidoRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @Override
    public Pedido criarPedido(String cliente, List<String> itens) {
        Pedido pedido = service.criar(cliente, itens);
        repository.salvar(pedido);
        return pedido;
    }
}
