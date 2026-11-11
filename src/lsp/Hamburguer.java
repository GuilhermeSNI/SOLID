package lsp;

public class Hamburguer extends Produto {
    private final int adicionais;

    public Hamburguer(String nome, double precoBase, int adicionais) {
        super(nome, precoBase);
        this.adicionais = Math.max(0, adicionais);
    }

    @Override
    public double calcularPreco() { return getPrecoBase() + adicionais * 3.5; }
}