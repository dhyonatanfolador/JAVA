package aulas.class_IV.construtores;

public class Pedido implements Pagamento, Notificacao {

    private final String codigo;
    private final double valor;

    public Pedido(String codigo, double valor) {
        this.codigo = codigo;
        this.valor = valor;
    }

    public void enviarNotificacao() {
        System.out.println("Pedido enviado com sucesso! - Codigo: " + codigo);
    }
    public void enviarPagamento() {
        System.out.println("Pagamento de R$ " + this.valor + " enviado com sucesso! - Pedido: " + codigo);
    }
}