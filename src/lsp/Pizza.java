package lsp;

public class Pizza extends Produto {
    private final boolean grande;

    public Pizza(String nome, double precoBase, boolean grande) {
        super(nome, precoBase);
        this.grande = grande;
    }

    @Override
    public double calcularPreco() { return getPrecoBase() + (grande ? 10.0 : 0.0); }
}