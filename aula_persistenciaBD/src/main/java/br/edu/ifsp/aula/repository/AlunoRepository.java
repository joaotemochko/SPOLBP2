package br.edu.ifsp.aula.repository;

import br.edu.ifsp.aula.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByNomeContainingIgnoreCase(String nome);
}
