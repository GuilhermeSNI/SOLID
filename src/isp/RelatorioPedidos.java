package isp;

import srp.PedidoRepository;

public class RelatorioPedidos implements GeradorRelatorio {
    private final PedidoRepository repository;

    public RelatorioPedidos(PedidoRepository repository) { this.repository = repository; }

    @Override
    public void gerarRelatorio() {
        System.out.println("Total de pedidos: " + repository.listarTodos().size());
    }
}