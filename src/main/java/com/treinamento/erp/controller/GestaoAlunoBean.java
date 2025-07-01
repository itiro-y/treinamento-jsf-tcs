package com.treinamento.erp.controller;
import com.treinamento.erp.model.Aluno;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.treinamento.erp.model.CursoNome;
import com.treinamento.erp.repository.AlunoRepository;
import com.treinamento.erp.util.FacesMessages;
import org.primefaces.PrimeFaces;

@Named("gestaoAlunoBean")
@ViewScoped
public class GestaoAlunoBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private AlunoRepository repository = AlunoRepository.obterInstancia();

    private FacesMessages messages;

    private String modalString;

    private Aluno aluno;
    private List<Aluno> listaAlunos;

    private String termoPesquisa;

    private Aluno alunoValidacao;

    @PostConstruct
    public void init() {
        this.messages = new FacesMessages();
        this.listaAlunos = repository.getDadosAlunos();
        this.aluno = null;
        this.alunoValidacao = new Aluno();
    }

    //Ex - 1
    public void validarAluno(){
        this.modalString = "";
        boolean flag = false;
        if(alunoValidacao.getNomeAluno() == null || alunoValidacao.getNomeAluno().trim().equals("")){
            modalString += "Nome é obrigatório\n";
        }

        if(alunoValidacao.getDataNascimento() == null){
            modalString += "Data de nascimento inválido!\n";
        }

        for(Aluno aluno : listaAlunos){
            if(alunoValidacao.getNomeAluno().equalsIgnoreCase(aluno.getNomeAluno())
                    && alunoValidacao.getDataNascimento().equals(aluno.getDataNascimento())){
                flag = true;
            }
        }

        if(flag){
            modalString += "Aluno encontrado!\n";
            PrimeFaces.current().ajax().addCallbackParam("validar", true);
        } else {
            modalString += "Erro: Aluno não encontrado\n";
            PrimeFaces.current().ajax().addCallbackParam("validar", true);
        }
    }

    public String getModalString() {
        return modalString;
    }

    public void setModalString(String modalString) {
        this.modalString = modalString;
    }

    public Aluno getAlunoValidacao() {
        return alunoValidacao;
    }

    public void setAlunoValidacao(Aluno alunoValidacao) {
        this.alunoValidacao = alunoValidacao;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public FacesMessages getMessages() {
        return messages;
    }

    public void setMessages(FacesMessages messages) {
        this.messages = messages;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getTermoPesquisa() {
        return termoPesquisa;
    }

    public void setTermoPesquisa(String termoPesquisa) {
        this.termoPesquisa = termoPesquisa;
    }

    public AlunoRepository getRepository() {
        return repository;
    }

    public void setRepository(AlunoRepository repository) {
        this.repository = repository;
    }

    public void prepararTodosAlunos(){
        listaAlunos = repository.getDadosAlunos();
    }

    public void salvarAluno() {
        boolean flag = true;
        if(aluno.getId() != null){
            for(int i = 0; i < listaAlunos.size(); i++){
                if(listaAlunos.get(i).getId().equals(aluno.getId())){
                    listaAlunos.set(i, aluno);
                    flag = false;
                    messages.info("Aluno editado com sucesso!");
                    break;
                }
            }
            if(flag){
                listaAlunos.add(aluno);
                messages.info("Aluno salvo com sucesso!");
            }
        }
        PrimeFaces.current().ajax().update(Arrays.asList("formTop:alunosDataTable", "formTop:messagesForm"));
    }

    public void deletarAluno(){
        repository.removerAluno(aluno);
        messages.info("Aluno: " + aluno.getNomeAluno() + " deletado(a) com sucesso!");
        PrimeFaces.current().ajax().update(Arrays.asList("formTop:alunosDataTable", "formTop:messagesForm"));
    }

    public void pesquisar(){
        List<Aluno> resultado = new ArrayList<>();
        for(Aluno a: repository.getDadosAlunos()){
            if(a.getNomeAluno().equalsIgnoreCase(termoPesquisa)){
                resultado.add(a);
            }
        }
        listaAlunos = resultado;
        if(listaAlunos.isEmpty()){
            messages.info("Sua consulta não retornou registros");
        }
    }

    public void prepararNovoAluno(){
        aluno = new Aluno();
        aluno.setCpf("000.000.000-00");
    }

    public CursoNome[] tiposCurso(){
        return CursoNome.values();
    }

    public boolean isAlunoSelecionado(){
        return aluno != null && aluno.getId() != null;
    }

    public void esvaziarAluno(){
        aluno = null;
    }

    public void printListaAlunos(){
        for(Aluno a : listaAlunos){
            System.out.println(a);
        }
        System.out.println();
    }

}
