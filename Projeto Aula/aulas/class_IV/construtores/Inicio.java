package aulas.class_IV.construtores;

public class Inicio {
    public static void main(String[] args) {

        Pedido primeiroPedido = new Pedido("387A", 432.37);

        primeiroPedido.enviarPagamento();
        primeiroPedido.enviarNotificacao();
    }
}