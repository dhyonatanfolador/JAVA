package aulas.class_III.abstracao;

public class Junior extends Empregado {
    @Override
    public double calcularSalario(double salario) {
        return salario * 1.25;
    }
}
