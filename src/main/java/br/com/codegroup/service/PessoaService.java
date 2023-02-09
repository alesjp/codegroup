package br.com.codegroup.service;

import br.com.codegroup.dto.PessoaDto;
import br.com.codegroup.model.Pessoa;
import br.com.codegroup.repository.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService implements IPessoaService {

    @Autowired
    private PessoaRepository repository;

    @Override
    public void saveOrUpdate(PessoaDto pessoaDto) {
        repository.save(convertToEntity(pessoaDto));
    }

    public List<PessoaDto> listaFuncionarios() {
        List<Pessoa> lista = repository.listaFuncionarios();
        return lista.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private PessoaDto convertToDto(Pessoa pessoa) {
        return new ModelMapper().map(pessoa, PessoaDto.class);
    }

    private Pessoa convertToEntity(PessoaDto pessoaDto) {
        return new ModelMapper().map(pessoaDto, Pessoa.class);
    }
}