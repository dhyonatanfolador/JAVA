package presencial.class_III.atividade_II;

import presencial.class_III.atividade_II.model.Pessoa;
import presencial.class_III.atividade_II.model.Aluno;
import presencial.class_III.atividade_II.model.Professor;
import presencial.class_III.atividade_II.model.Turma;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Turma turma_1 = new Turma("201°");
        Turma turma_2 = new Turma("101°");
        Aluno aluno_1 = new Aluno();
        Aluno aluno_2 = new Aluno();
        Aluno aluno_3 = new Aluno();
        Aluno aluno_4 = new Aluno();
        Professor professor = new Professor();

        professor.setNome("Leonardo");
        professor.setIdade(String.valueOf(42));
        professor.setSalario(2500.0);

        aluno_1.setNome("Dhyonatan");
        aluno_1.setIdade(String.valueOf(17));
        aluno_1.setNota(10.0);
        aluno_2.setNome("Ronye");
        aluno_2.setIdade(String.valueOf(17));
        aluno_2.setNota(10.0);

        aluno_3.setNome("Marco");
        aluno_3.setIdade(String.valueOf(22));
        aluno_3.setNota(9.2);
        aluno_4.setNome("Rodrigo");
        aluno_4.setIdade(String.valueOf(19));
        aluno_4.setNota(8.5);

        turma_1.adicionaProfessor(professor);
        turma_1.adicionaAluno(aluno_1);
        turma_1.adicionaAluno(aluno_2);

        turma_2.adicionaProfessor(professor);
        turma_2.adicionaAluno(aluno_3);
        turma_2.adicionaAluno(aluno_4);

        System.out.println("\nTurma: " + turma_1.getNome());
        System.out.println("---------------");
        turma_1.visualizaTurma(turma_1.getListaAlunos(), turma_1.getProfessor());

        System.out.println("\n\n");

        System.out.println("\nTurma: " + turma_2.getNome());
        System.out.println("---------------");
        turma_1.visualizaTurma(turma_2.getListaAlunos(), turma_2.getProfessor());

    }
}
