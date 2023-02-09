package br.com.codegroup.repository;

import br.com.codegroup.model.Projeto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProjetoRepositoryTest {

    @Autowired
    ProjetoRepository repository;

    @Test
    void testCreateReadDelete() {
        Projeto projeto = new Projeto();
        projeto.setNome("Meu Projeto");

        repository.save(projeto);

        Projeto pe = repository.findById(projeto.getId()).get();
        Assertions.assertThat(pe.getNome()).contains("Meu Projeto");

        repository.deleteById(projeto.getId());
        Assertions.assertThat(repository.findById(projeto.getId())).isEmpty();
    }
}
