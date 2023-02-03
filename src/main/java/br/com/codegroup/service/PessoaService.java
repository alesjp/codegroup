package br.com.codegroup.service;

import br.com.codegroup.model.Pessoa;
import br.com.codegroup.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService implements IPessoaService {

    @Autowired
    private PessoaRepository repository;

    @Override
    public Pessoa save(Pessoa Pessoa) {
        return repository.save(Pessoa);
    }

    public List<Pessoa> listaFuncionarios() {
        return repository.listaFuncionarios();
    }
}