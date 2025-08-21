package aulas.class_II.getters_setters;

//AULA_3
public class Usuario {

    private String nome;
    private int idade;
    private String cpf;
    private boolean login = false;

    public boolean Esta_Logado() {
        return this.login;
    }

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
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public boolean isLogin() {
        return login;
    }
    public void setLogin(boolean login) {
        this.login = login;
    }
}
