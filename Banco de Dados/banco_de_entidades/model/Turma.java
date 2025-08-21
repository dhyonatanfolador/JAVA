package org.banco_de_entidades.model;

import java.util.List;

public class Turma<T> {
    private int id;
    private String nome;
    private Professor professor;
    private List<Estudante> estudantes;

    public Turma(int id, String nome, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.professor = professor;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    public Estudante getEstudantes() {
        return estudantes;
    }
    public void setEstudantes(List<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

    public void adicionarEstudante(Estudante estudante) {
        this.estudantes.add(estudante);
    }
    public void removerEstudante(Estudante estudante) {
        this.estudantes.remove(estudante);
    }
}
