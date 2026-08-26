package br.edu.sistemaacademico.domain;

import java.util.ArrayList;
import java.util.List;

public class OfertaDisciplina {

    private Turma turma;
    private Disciplina disciplina;
    private List<Matricula> matriculas = new ArrayList<>();

    public OfertaDisciplina(Turma turma, Disciplina disciplina) {
        if (turma == null) {
            throw new IllegalArgumentException("Turma é obrigatória");
        }

        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina é obrigatória");
        }

        this.turma = turma;
        this.disciplina = disciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Matricula matricular(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno é obrigatório");
        }

        for (Matricula matricula : matriculas) {
            if (matricula.getAluno().equals(aluno)) {
                throw new IllegalArgumentException(
                        "Aluno já está matriculado nesta oferta"
                );
            }
        }

        if (aluno.jaFoiAprovadoNaDisciplina(disciplina)) {
            throw new IllegalStateException(
                    "Aluno já foi aprovado nesta disciplina"
            );
        }

        Matricula matricula = new Matricula(aluno, this);

        matriculas.add(matricula);
        aluno.adicionarMatricula(matricula);

        return matricula;
    }

    public List<Matricula> getMatriculas() {
        return new ArrayList<>(matriculas);
    }

    @Override
    public String toString() {
        return disciplina + " - " + turma.getCodigo();
    }
}
