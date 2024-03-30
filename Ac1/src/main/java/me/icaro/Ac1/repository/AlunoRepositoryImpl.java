package me.icaro.Ac1.repository;

import me.icaro.Ac1.modelo.Aluno;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

@Repository
public class AlunoRepositoryImpl implements AlunoRepository {

    private final JdbcTemplate jdbcTemplate;

    public AlunoRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Aluno> findAll(){

        return jdbcTemplate.query("SELECT * FROM aluno", (resultSet, rowNum) ->{
            System.out.println("Numero da linha: " + rowNum);
            return new Aluno(
                resultSet.getLong("id"),
                resultSet.getString("nome"),
                resultSet.getString("sexo"),
                resultSet.getString("email"),
                resultSet.getString("telefone")
            );
        });
    }

    @Override
    public Aluno findById (Long id){
        String query = "SELECT * FROM aluno where id = ?";

        return jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, rowNum) ->
                new Aluno
                        (
                        resultSet.getLong("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("sexo"),
                        resultSet.getString("email"),
                        resultSet.getString("telefone")
                        )
                );
    }

    @Override
    public Aluno save(Aluno aluno){
        if (aluno.getId() != null){
            String insertQuery = "INSERT INTO public.aluno (id, nome, sexo, email, telefone) VALUES (?,?,?,?,?)";

            jdbcTemplate.update(insertQuery, aluno.getId(), aluno.getNome(), aluno.getSexo(), aluno.getEmail(), aluno.getTelefone());

        } else{
            String updateQuery = "UPDATE public.aluno SET nome = ?, sexo = ?, email = ?, telefone = ? WHERE id = ?";
            jdbcTemplate.update(updateQuery, aluno.getNome(), aluno.getSexo(), aluno.getEmail(), aluno.getTelefone(), aluno.getId());
        }
        return aluno;

    }

}
