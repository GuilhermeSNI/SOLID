package ocp;

public class ProcessadorPagamento {
    public void processar (FormaPagamento forma, double valor){
        forma.pagar(valor);
    }
}
