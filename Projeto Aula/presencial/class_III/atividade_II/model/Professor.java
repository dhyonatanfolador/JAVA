package presencial.class_III.atividade_II.model;

public class Professor extends Pessoa {
    public Professor(String nome, String idade) {
        super(nome, idade);
    }
    public Professor() {}

    double salario;

    //GETTER AND SETTER
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
}
