package ocp;

public class PagamentoPix implements FormaPagamento {
    private final String chave;

    public PagamentoPix(String chave) {
        this.chave = chave;
    }

    @Override
    public void pagar(double valor) {
        System.out.println("Pagando R$ " + valor + " via PIX (chave: " + chave + ").");
    }
}
