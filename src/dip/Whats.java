package dip;

public class Whats implements Notificador {
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("[WHATSAPP] " + destinatario + ": " + mensagem);
    }
}