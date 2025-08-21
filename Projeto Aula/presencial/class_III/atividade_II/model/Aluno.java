package presencial.class_III.atividade_II.model;

public class Aluno extends Pessoa {
    public Aluno(String nome, String idade) {
        super(nome, idade);
    }
    public Aluno() {}

    double nota;

    //GETTER AND SETTER
    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }
}
