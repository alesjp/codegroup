package br.com.codegroup.repository;

import br.com.codegroup.model.Pessoa;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PessoaRepositoryTest {

    @Autowired
    PessoaRepository repository;

    @Test
    public void testCreateReadDelete() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Alexandre");
        pessoa.setCpf("12312312312");
        pessoa.setDataNascimento(new Date());
        pessoa.setFuncionario(true);

        repository.save(pessoa);

        Pessoa pe = repository.findById(pessoa.getId()).get();
        Assertions.assertThat(pe.getNome()).contains("Alexandre");

        repository.deleteById(pessoa.getId());
        Assertions.assertThat(repository.findById(pessoa.getId())).isEmpty();
    }
}
