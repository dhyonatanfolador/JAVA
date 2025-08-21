package org.banco_de_entidades.model;

public class Estudante extends Pessoa {
    private String matricula;

    public Estudante(int id, String nome, String email, String matricula) {
        super(id, nome, email);
        this.matricula = matricula;
    }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    @Override
    public String toString() {
        return "Estudante [ ID: " + getId() + ", Nome: " + getNome() + ", Email: " + getEmail() + ", Matricula: " + matricula + " ]";
    }
}
