package dip;

import srp.Pedido;

public class NotificacaoService {
    private final Notificador notificador; // depende da abstração

    public NotificacaoService(Notificador notificador) { this.notificador = notificador; }

    public void avisarPedido(Pedido pedido, String destinatario) {
        notificador.enviar(destinatario, "Seu pedido #" + pedido.getId() + " saiu para entrega!");
    }
}