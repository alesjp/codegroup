package br.com.codegroup.service;

import br.com.codegroup.model.Projeto;

import java.util.List;
import java.util.Optional;

public interface IProjetoService {

    List<Projeto> findAll();

    Optional<Projeto> findById(Long id);

    void saveOrUpdate(Projeto projeto);

    void deleteById(Long id);

}