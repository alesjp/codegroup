package br.com.codegroup.service;

import br.com.codegroup.dto.ProjetoDto;
import br.com.codegroup.model.Projeto;
import br.com.codegroup.repository.ProjetoRepository;
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
class ProjetoServiceTest {

    @InjectMocks
    ProjetoService service;

    @Mock
    ProjetoRepository dao;

    @Test
    void testFindAll() {
        List<Projeto> list = new ArrayList<>();
        Projeto projetoUm = new Projeto();
        Projeto projetoDois = new Projeto();

        list.add(projetoUm);
        list.add(projetoDois);

        when(dao.findAll()).thenReturn(list);

        List<ProjetoDto> listaProjeto = service.findAll();

        assertEquals(2, listaProjeto.size());
        verify(dao, times(1)).findAll();
    }

    @Test
    void testSaveOrUpdate() {
        ProjetoDto projetoDto = new ProjetoDto();
        service.saveOrUpdate(projetoDto);
        verify(dao, times(1)).save(new Projeto());
    }

    @Test
    void testFindById() {
        service.findById(1l);
        verify(dao, times(1)).findById(1l);
    }

    @Test
    void testDeleteById() {
        service.deleteById(1l);
        verify(dao, times(1)).deleteById(1l);
    }
}
