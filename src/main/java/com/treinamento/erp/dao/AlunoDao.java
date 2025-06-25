package com.treinamento.erp.dao;

import com.treinamento.erp.model.Aluno;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class AlunoDao {

    @PersistenceContext(unitName = "TcsTreinamentoJSF")
    private EntityManager em;

    public AlunoDao() {}

    public AlunoDao(EntityManager em) {
        this.em = em;
    }

    // GET all
    public List<Aluno> getAlunos(){
        return em.createQuery("from Aluno", Aluno.class).getResultList();
    }

    // GET byID
    public Aluno getAlunoById(Long id){
        return em.find(Aluno.class, id);
    }

    // GET byName
    public List<Aluno> getAlunoByNome(String nome){
        String jpql = "from Aluno where nomeAluno like :nomeAluno";
        TypedQuery<Aluno> query = em.createQuery(jpql, Aluno.class);
        query.setParameter("nomeAluno", nome + "%");
        return query.getResultList();
    }

    // POST
    public void postAluno(Aluno aluno){
        em.merge(aluno);
    }

    // DELETE
    public void deleteAluno(Aluno aluno){
        em.remove(aluno);
    }
}
