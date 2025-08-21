package aulas.class_III.abstracao;

public class Inicio {
    public static void main(String[] args) {

        //CLASSE ABSTRATA NAO PODE SER INSTANCIADA
        Empregado dhyonatan = new Estagiario();
        Empregado andre = new Junior();

        dhyonatan.cadastro("Dhyonatan", 16);
        andre.cadastro("Andre", 22);

        System.out.println("\n" + dhyonatan.toString());
        System.out.println("Salario: " + dhyonatan.calcularSalario(4000));

        System.out.println("\n" + andre.toString());
        System.out.println("Salario: " + andre.calcularSalario(2000));
    }
}
