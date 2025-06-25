package com.treinamento.erp.controller;

import com.treinamento.erp.dao.AlunoDao;
import com.treinamento.erp.model.Aluno;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import com.treinamento.erp.util.FacesMessages;

@Named("gestaoAlunoBean")
@ViewScoped
public class GestaoAlunoBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private FacesMessages facesMessages;

    @Inject
    private AlunoDao alunoDao;

    private Aluno aluno;
    private List<Aluno> alunos;



}
