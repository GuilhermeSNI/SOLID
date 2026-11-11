package ocp;

public class PagamentoDinheiro implements FormaPagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagando R$ " + valor + " em dinheiro.");
    }
}
