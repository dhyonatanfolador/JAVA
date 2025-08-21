package aulas.class_III.abstracao;

public abstract class Empregado {

    //ATRIBUICOES
    private String nome;
    private int idade;

    //METODO ABSTRATO NAO PERMITE IMPLEMENTACAO
    public abstract double calcularSalario(double salario);

    public void cadastro(String nome, int idade) {
        this.setNome(nome);
        this.setIdade(idade);
    }
    //GETTERS AND SETTERS
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return this.getNome() + " - " + this.getIdade() + " anos";
    }
}
