package com.treinamento.erp.model;

public enum CursoNome {

    CDC("Ciência da Computação"),
    ADS("Análise e Desenvolvimento de Software"),
    PSI("Psicologia"),
    MED("Medicina"),
    ENG("Engenharia");

    private String descricao;

    CursoNome(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "CursoNome{" +
                "descricao='" + descricao + '\'' +
                '}';
    }
}
