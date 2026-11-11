package dip;

public class Email implements Notificador {
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("[EMAIL] " + destinatario + ": " + mensagem);
    }
}