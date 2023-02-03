package br.com.codegroup.controller;

import br.com.codegroup.model.Pessoa;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class PessoaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    PessoaController controller;

    @Test
    public void contextLoads() {
        Assertions.assertThat(controller).isNotNull();
    }

    @Test
    void testNovaPessoaExpectOk() throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Alexandre");
        pessoa.setCpf("12312312312");
        pessoa.setDataNascimento(new Date());
        pessoa.setFuncionario(true);

        mockMvc.perform(post("/pessoa")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(objectMapper.writeValueAsBytes(pessoa)))
                .andExpect(status().isOk());
    }
}
