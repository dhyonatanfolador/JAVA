package org.banco_de_entidades.dao;

import org.banco_de_entidades.model.Turma;

public interface ITurmaDAO extends IDAO<Turma> {
    void adicionarEstudante(int turmaId, int estudanteId);
    void removerEstudante(int turmaId, int estudanteId);
    void transferirEstudante(int IdEstudante, int turmaOrigem, int turmaDestino);
}
