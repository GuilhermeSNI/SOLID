package ocp;

public class PagamentoCartao implements FormaPagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagando R$ " + valor + " no cartão.");
    }
}
