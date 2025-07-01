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
        alunos.add(new Aluno(6L, "Juliana Mendes", "123.456.789-09", newDate(1997, 9, 14), CursoNome.MED));
        alunos.add(new Aluno(7L, "Renato Lima", "987.654.321-00", newDate(1996, 3, 30), CursoNome.ENG));
        alunos.add(new Aluno(8L, "Fernanda Rocha", "852.741.963-20", newDate(2002, 11, 5), CursoNome.MED));
        alunos.add(new Aluno(9L, "Bruno Castro", "741.852.963-18", newDate(1994, 6, 27), CursoNome.ADS));
        alunos.add(new Aluno(10L, "Larissa Souza", "369.258.147-01", newDate(1999, 2, 9), CursoNome.PSI));
        alunos.add(new Aluno(11L, "Mateus Ribeiro", "159.753.486-20", newDate(1993, 10, 12), CursoNome.CDC));
        alunos.add(new Aluno(12L, "Isabela Martins", "321.654.987-00", newDate(1998, 8, 3), CursoNome.MED));
        alunos.add(new Aluno(13L, "Thiago Almeida", "258.369.147-77", newDate(2001, 1, 25), CursoNome.ADS));
        alunos.add(new Aluno(14L, "Camila Duarte", "147.258.369-80", newDate(1995, 5, 17), CursoNome.ENG));
        alunos.add(new Aluno(15L, "Gabriel Monteiro", "753.159.842-66", newDate(2000, 12, 6), CursoNome.PSI));
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
