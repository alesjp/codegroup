package br.com.codegroup.controller;

import br.com.codegroup.dto.PessoaDto;
import br.com.codegroup.service.IPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PessoaController {

    @Autowired
    private IPessoaService service;

    @PostMapping(value = "/pessoas")
    public PessoaDto novaPessoa(@Valid @RequestBody PessoaDto pessoaDto) {
        service.saveOrUpdate(pessoaDto);
        return new ResponseEntity<>(pessoaDto, HttpStatus.OK).getBody();
    }
}
