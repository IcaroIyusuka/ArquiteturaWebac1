package me.icaro.Ac1.modelo;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import me.icaro.Ac1.config.HibernateConfig;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlunoRepositoryImpl implements AlunoRepository {

    private final SessionFactory sessionFactory;

    public AlunoRepositoryImpl(){
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Aluno> findAll(){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        List<Aluno> alunos = session.createQuery("FROM Aluno", Aluno.class).getResultList();
        transaction.commit();
        return alunos;
    }



    @Override
    public Aluno findById(Long id){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Aluno aluno = session.find(Aluno.class, id);
        transaction.commit();
        return aluno;
    }

    @Override
    public Aluno save(Aluno aluno){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(aluno);
        transaction.commit();
        return aluno;
    }



    @Override
    public Aluno delete(int id){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        Aluno aluno = session.get(Aluno.class, id);
        if(aluno != null){
            session.delete(aluno);
            transaction.commit();
            return aluno;
        }else{
            transaction.rollback();
            return null;
        }
//        String hqlQuery = "DELETE FROM aluno WHERE id = :alunoId";
//        Query query = session.createQuery(hqlQuery);
//        query.setParameter("alunoId", id);
//
//        int deleteCount = query.executeUpdate();
//        transaction.commit();
//
//        if (deleteCount > 0 ){
//            return new Aluno();
//        } else {
//            return null;
//        }
    }


}
