package br.com.codegroup.service;

import br.com.codegroup.model.Pessoa;

import java.util.List;

public interface IPessoaService {

    Pessoa save(Pessoa Pessoa);

    List<Pessoa> listaFuncionarios();
}