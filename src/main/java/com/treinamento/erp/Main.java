package com.treinamento.erp;

import com.treinamento.erp.model.Aluno;
import com.treinamento.erp.repository.AlunoRepository;

public class Main {
    public static void main(String[] args) {
        AlunoRepository repository = AlunoRepository.obterInstancia();

        for(Aluno a : repository.getDadosAlunos()){
            System.out.println(a);
        }
    }
}
