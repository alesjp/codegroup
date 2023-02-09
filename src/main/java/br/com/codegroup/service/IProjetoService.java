package br.com.codegroup.service;

import br.com.codegroup.dto.ProjetoDto;

import java.util.List;

public interface IProjetoService {

    List<ProjetoDto> findAll();

    ProjetoDto findById(Long id);

    void saveOrUpdate(ProjetoDto projeto);

    void deleteById(Long id);

}