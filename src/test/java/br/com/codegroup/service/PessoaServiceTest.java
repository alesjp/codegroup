package br.com.codegroup.service;

import br.com.codegroup.model.Pessoa;
import br.com.codegroup.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class PessoaServiceTest {

    @InjectMocks
    PessoaService service;

    @Mock
    PessoaRepository dao;

    @Test
    public void testListaFuncionarios() {
        List<Pessoa> list = new ArrayList<>();
        Pessoa pessoaUm = new Pessoa();
        Pessoa pessoaDois = new Pessoa();

        list.add(pessoaUm);
        list.add(pessoaDois);

        when(dao.listaFuncionarios()).thenReturn(list);

        List<Pessoa> listaPessoas = service.listaFuncionarios();

        assertEquals(2, listaPessoas.size());
        verify(dao, times(1)).listaFuncionarios();
    }

    @Test
    public void testSave() {
        Pessoa pessoa = new Pessoa();
        service.save(pessoa);
        verify(dao, times(1)).save(pessoa);
    }
}
