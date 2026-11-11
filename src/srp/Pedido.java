package srp;

import java.util.List;

public class Pedido {
    private final int id;
    private final String cliente;
    private final List<String> itens;

    public Pedido(int id, String cliente, List<String> itens) {
        this.id = id;
        this.cliente = cliente;
        this.itens = itens;
    }

    public int getId() { return id; }
    public String getCliente() { return cliente; }
    public List<String> getItens() { return itens; }
}