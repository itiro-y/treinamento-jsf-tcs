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
        alunos.add(new Aluno(1L, "Lucas Ferreira", "779.602.190-95", newDate(1999, 12, 2), CursoNome.ADS));
        alunos.add(new Aluno(2L, "Mariana Silva", "997.033.110-83", newDate(1995, 5, 20), CursoNome.CDC));
        alunos.add(new Aluno(3L, "Pedro Costa", "613.495.400-48", newDate(2000, 1, 11), CursoNome.ENG));
        alunos.add(new Aluno(4L, "Ana Beatriz", "427.025.600-16", newDate(2001, 4, 21), CursoNome.MED));
        alunos.add(new Aluno(5L, "Carlos Oliveira", "335.157.980-21", newDate(1998, 7, 15), CursoNome.PSI));
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
