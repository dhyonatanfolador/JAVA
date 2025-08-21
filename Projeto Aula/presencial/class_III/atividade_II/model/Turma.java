package presencial.class_III.atividade_II.model;

import java.util.ArrayList;

public class Turma {
    ArrayList<Aluno> listaAlunos;
    Professor professor;
    String nome;

    public Turma(String nome) {
        this.nome = nome;
        this.listaAlunos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void adicionaAluno(Aluno a) {
        listaAlunos.add(a);
    }
    public void adicionaProfessor(Professor p) {
        this.professor = p;
    }
    public ArrayList<Aluno> getListaAlunos() {
        return listaAlunos;
    }
    public Professor getProfessor() {
        return professor;
    }

    public void visualizaTurma(ArrayList<Aluno> a, Professor p) {
        System.out.println("Professor:");
        System.out.println("---------------");
        System.out.println("Nome: " + professor.getNome() +
                           "\nIdade: " + professor.getIdade() +
                           "\nSalario: " + professor.getSalario()
        );
        System.out.println("---------------");
        System.out.println("Alunos:");
        System.out.println("---------------");
        for (Aluno aluno : a) {
            System.out.println("Nome: "  + aluno.getNome());
            System.out.println("Idade: " + aluno.getIdade());
            System.out.println("Nota: "  + aluno.getNota());
            System.out.println("---------------");
        }
    }
}
