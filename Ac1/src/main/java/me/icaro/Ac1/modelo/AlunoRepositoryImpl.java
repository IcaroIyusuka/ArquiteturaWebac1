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
    public Aluno createAluno(Aluno aluno){
        Session session = getSession();
        Transaction transaction = session.beginTransaction(); // Iniciar a transação

        String insertQuery ="\"INSERT INTO public.aluno (id, nome, sexo, email, telefone) VALUES (?,?,?,?,?)";
        Query query = session.createQuery(insertQuery);

        query.setParameter("id", aluno.getId());
        query.setParameter("nome", aluno.getNome());
        query.setParameter("sexo", aluno.getSexo());
        query.setParameter("email", aluno.getEmail());
        query.setParameter("telefone", aluno.getTelefone());

        query.executeUpdate();


        // Commit da transação
        transaction.commit();

        return aluno;
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
        session.remove(aluno);
        transaction.commit();
        return aluno;
    }

    @Override
    public Aluno update(Aluno aluno) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction(); // Iniciar a transação

        // Definir a query de atualização
        String updQuery = "UPDATE Aluno SET nome = :nome, sexo = :sexo, email = :email, telefone = :telefone WHERE id = :id";
        Query query = session.createQuery(updQuery);

        // Definir os parâmetros da query de atualização
        query.setParameter("nome", aluno.getNome());
        query.setParameter("sexo", aluno.getSexo());
        query.setParameter("email", aluno.getEmail());
        query.setParameter("telefone", aluno.getTelefone());
        query.setParameter("id", aluno.getId());

        // Executar a atualização
        int result = query.executeUpdate();

        // Commit da transação
        transaction.commit();

        return aluno;
    }



    @Override
    public Aluno delete(int id){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        String hqlQuery = "DELETE FROM aluno WHERE id = :alunoId";
        Query query = session.createQuery(hqlQuery);
        query.setParameter("alunoId", id);

        int deleteCount = query.executeUpdate();
        transaction.commit();

        if (deleteCount > 0 ){
            return new Aluno();
        } else {
            return null;
        }
    }


}
