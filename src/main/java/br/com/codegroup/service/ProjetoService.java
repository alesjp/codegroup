package br.com.codegroup.service;

import br.com.codegroup.dto.ProjetoDto;
import br.com.codegroup.model.Projeto;
import br.com.codegroup.repository.ProjetoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjetoService implements IProjetoService {

    @Autowired
    private ProjetoRepository repository;

    @Override
    public List<ProjetoDto> findAll() {
        List<Projeto> lista = repository.findAll();
        return lista.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProjetoDto findById(Long id) {
        Optional<Projeto> projeto = repository.findById(id);
        if (projeto.isPresent()) {
            return convertToDto(projeto.get());
        } else {
            return null;
        }
    }

    @Override
    public void saveOrUpdate(ProjetoDto projetoDto) {
        repository.save(convertToEntity(projetoDto));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private ProjetoDto convertToDto(Projeto projeto) {
        return new ModelMapper().map(projeto, ProjetoDto.class);
    }

    private Projeto convertToEntity(ProjetoDto projetoDto) {
        return new ModelMapper().map(projetoDto, Projeto.class);
    }
}