package br.com.codegroup.service;

import br.com.codegroup.dto.PessoaDto;

import java.util.List;

public interface IPessoaService {

    void saveOrUpdate(PessoaDto pessoaDto);

    List<PessoaDto> listaFuncionarios();
}