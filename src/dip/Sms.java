package dip;

public class Sms implements Notificador {
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("[SMS] " + destinatario + ": " + mensagem);
    }
}