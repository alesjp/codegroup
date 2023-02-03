package br.com.codegroup.controller;

import br.com.codegroup.model.Pessoa;
import br.com.codegroup.service.IPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PessoaController {

    @Autowired
    private IPessoaService service;

    @RequestMapping(value = "/pessoa", method = RequestMethod.POST)
    public Pessoa novaPessoa(@Valid @RequestBody Pessoa pessoa) {
        service.save(pessoa);
        return new ResponseEntity<>(pessoa, HttpStatus.OK).getBody();
    }
}
