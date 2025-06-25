package com.treinamento.erp.repository;

import com.treinamento.erp.model.Aluno;
import com.treinamento.erp.model.CursoNome;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlunoRepository {
    private static AlunoRepository instancia;

    // Banco de Alunos
    private final List<Aluno> alunos;

    public AlunoRepository() {
       this.alunos = new ArrayList<Aluno>();
       popularDadosIniciais();
    }

    public static AlunoRepository obterInstancia() {
        if (instancia == null) {
            instancia = new AlunoRepository();
        }
        return instancia;
    }

    public void popularDadosIniciais(){
        alunos.add(new Aluno(1L, "Lucas Ferreira", "123.456.789-00", newDate(1999, 12, 2), CursoNome.ADS));
        alunos.add(new Aluno(2L, "Mariana Silva", "987.654.321-00", newDate(1995, 5, 20), CursoNome.CDC));
        alunos.add(new Aluno(3L, "Pedro Costa", "456.789.123-00", newDate(2000, 1, 11), CursoNome.ENG));
        alunos.add(new Aluno(4L, "Ana Beatriz", "321.654.987-00", newDate(2001, 4, 21), CursoNome.MED));
        alunos.add(new Aluno(5L, "Carlos Oliveira", "159.753.486-00", newDate(1998, 7, 15), CursoNome.PSI));
    }

    public List<Aluno> getDadosAlunos() {
        return alunos;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public Date newDate(int year, int month, int day){
        LocalDate localDate = LocalDate.of(year, month, day);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return date;
    }
}
