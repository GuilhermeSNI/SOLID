package lsp;

public abstract class Produto {
    private final String nome;
    private final double precoBase;

    protected Produto(String nome, double precoBase) {
        if (precoBase < 0) throw new IllegalArgumentException("Preço não pode ser negativo.");
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public String getNome() { return nome; }
    protected double getPrecoBase() { return precoBase; }

    // Contrato: retorna sempre >= 0 e nunca lança exceção.
    // Toda subclasse precisa respeitar isso para poder substituir Produto.
    public abstract double calcularPreco();
}
