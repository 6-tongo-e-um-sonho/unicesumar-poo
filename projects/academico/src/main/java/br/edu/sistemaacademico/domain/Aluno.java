package br.edu.sistemaacademico.domain;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private String identificador;
    private String nome;
    private String email;

    private List<Matricula> matriculas = new ArrayList<>();

    public Aluno(String identificador, String nome, String email) {
        if (identificador == null || identificador.isBlank()) {
            throw new IllegalArgumentException("Identificador do aluno é obrigatório");
        }

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do aluno é obrigatório");
        }

        if (email == null || email.isBlank() || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }

        this.identificador = identificador;
        this.nome = nome;
        this.email = email;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public List<Matricula> getMatriculas() {
        return new ArrayList<>(matriculas);
    }

    public void adicionarMatricula(Matricula matricula) {
        if (matricula == null) {
            throw new IllegalArgumentException("Matrícula não pode ser nula");
        }

        matriculas.add(matricula);
    }

    public boolean jaFoiAprovado(Disciplina disciplina) {
        for (Matricula matricula : matriculas) {
            if (matricula.getOferta().getDisciplina().equals(disciplina)
                    && matricula.getResultado() == ResultadoAcademico.APROVADO) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return identificador + " - " + nome;
    }
}
