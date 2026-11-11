package lsp;

public class Bebida extends Produto {
    public Bebida(String nome, double precoBase) { super(nome, precoBase); }

    @Override
    public double calcularPreco() { return getPrecoBase(); }
}
