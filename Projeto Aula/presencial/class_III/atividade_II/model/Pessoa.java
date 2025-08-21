package presencial.class_III.atividade_II.model;

public abstract class Pessoa {
    String nome;
    String idade;

    public Pessoa(String nome, String idade) {
        this.nome = nome;
        this.idade = idade;
    }
    public Pessoa() {}

    //GETTER AND SETTER
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getIdade() {
        return idade;
    }
    public void setIdade(String idade) {
        this.idade = idade;
    }
}
