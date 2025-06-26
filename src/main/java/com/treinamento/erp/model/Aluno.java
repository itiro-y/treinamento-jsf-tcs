package com.treinamento.erp.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;

    @NotEmpty
    private String nomeAluno;

    private String cpf;

    @NotNull
    @Past
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @NotNull
    private CursoNome curso;

    public Aluno() {

    }

    public Aluno(Long id, String nomeAluno, String cpf, Date dataNascimento, CursoNome curso) {
        this.id = id;
        this.nomeAluno = nomeAluno;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public CursoNome getCurso() {
        return curso;
    }

    public void setCurso(CursoNome curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(id, aluno.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nomeAluno='" + nomeAluno + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", curso=" + curso +
                '}';
    }
}
