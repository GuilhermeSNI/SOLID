import dip.Email;
import dip.NotificacaoService;
import dip.Notificador;
import dip.Sms;
import dip.Whats;
import isp.GeradorRelatorio;
import isp.GerenciadorEntregas;
import isp.GerenciadorPedidos;
import isp.GestaoEntregas;
import isp.GestaoPedidos;
import isp.RelatorioPedidos;
import lsp.Bebida;
import lsp.Hamburguer;
import lsp.Pizza;
import lsp.Produto;
import ocp.FormaPagamento;
import ocp.PagamentoCartao;
import ocp.PagamentoDinheiro;
import ocp.PagamentoPix;
import ocp.ProcessadorPagamento;
import srp.Pedido;
import srp.PedidoRepository;
import srp.PedidoService;
import srp.PedidoView;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ===== SRP: cada classe tem uma única responsabilidade =====
        // PedidoService cria, PedidoRepository salva, PedidoView exibe.
        titulo("SRP - Criar, salvar e exibir pedido");
        PedidoService service = new PedidoService();
        PedidoRepository repository = new PedidoRepository();
        PedidoView view = new PedidoView();

        Pedido pedido = service.criar("Maria", List.of("Pizza", "Guaraná"));
        repository.salvar(pedido);
        view.exibir(pedido);

        // ===== OCP: novas formas de pagamento sem alterar código existente =====
        titulo("OCP - Formas de pagamento");
        ProcessadorPagamento processador = new ProcessadorPagamento();
        processador.processar(new PagamentoCartao(), 50.0);
        processador.processar(new PagamentoPix("maria@email.com"), 50.0);
        processador.processar(new PagamentoDinheiro(), 50.0);

        // Nova forma de pagamento criada SEM mexer em nenhuma classe existente
        // (FormaPagamento tem um único método, então pode ser uma lambda):
        FormaPagamento boleto = valor -> System.out.println("Pagando R$ " + valor + " via boleto.");
        processador.processar(boleto, 50.0);

        // ===== LSP: qualquer subclasse funciona no lugar de Produto =====
        titulo("LSP - Produtos");
        List<Produto> produtos = List.of(
                new Pizza("Calabresa", 40.0, true),
                new Hamburguer("X-Bacon", 25.0, 2),
                new Bebida("Guaraná", 10.0)
        );
        double total = 0;
        for (Produto p : produtos) {
            System.out.println(p.getNome() + ": R$ " + p.calcularPreco());
            total += p.calcularPreco();
        }
        System.out.println("Total: R$ " + total);

        // ===== ISP: interfaces pequenas e específicas =====
        titulo("ISP - Pedidos, entregas e relatórios");
        GerenciadorPedidos pedidos = new GestaoPedidos(service, repository);
        Pedido pedido2 = pedidos.criarPedido("João", List.of("X-Bacon"));

        GerenciadorEntregas entregas = new GestaoEntregas();
        entregas.entregar(pedido, "Carlos");
        entregas.entregar(pedido2, "Carlos");

        GeradorRelatorio relatorio = new RelatorioPedidos(repository);
        relatorio.gerarRelatorio();

        // ===== DIP: o serviço depende da abstração Notificador =====
        titulo("DIP - Notificações");
        Notificador[] meios = { new Email(), new Sms(), new Whats() };
        String[] destinos = { "maria@email.com", "(43) 99999-0000", "(43) 99999-0000" };
        for (int i = 0; i < meios.length; i++) {
            new NotificacaoService(meios[i]).avisarPedido(pedido, destinos[i]);
        }
    }

    private static void titulo(String texto) {
        System.out.println("\n=== " + texto + " ===");
    }
}
