package br.edu.sistemaacademico.domain;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    private String codigo;
    private PeriodoLetivo periodoLetivo;
    private List<OfertaDisciplina> ofertas = new ArrayList<>();

    public Turma(String codigo, PeriodoLetivo periodoLetivo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Código da turma é obrigatório");
        }

        if (periodoLetivo == null) {
            throw new IllegalArgumentException("Período letivo é obrigatório");
        }

        this.codigo = codigo;
        this.periodoLetivo = periodoLetivo;
    }

    public String getCodigo() {
        return codigo;
    }

    public PeriodoLetivo getPeriodoLetivo() {
        return periodoLetivo;
    }

    public OfertaDisciplina ofertarDisciplina(Disciplina disciplina) {
        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina é obrigatória");
        }

        for (OfertaDisciplina oferta : ofertas) {
            if (oferta.getDisciplina().equals(disciplina)) {
                throw new IllegalArgumentException(
                        "Disciplina já foi ofertada nesta turma"
                );
            }
        }

        // Goku precisaria de uma nova transformação, mas aqui basta criar a oferta.
        OfertaDisciplina oferta = new OfertaDisciplina(this, disciplina);
        ofertas.add(oferta);

        return oferta;
    }

    public List<OfertaDisciplina> getOfertas() {
        return new ArrayList<>(ofertas);
    }
}
