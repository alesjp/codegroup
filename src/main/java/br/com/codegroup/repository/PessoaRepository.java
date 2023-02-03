package br.com.codegroup.repository;

import br.com.codegroup.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("SELECT p FROM Pessoa p WHERE p.funcionario = true")
    List<Pessoa> listaFuncionarios();

}
