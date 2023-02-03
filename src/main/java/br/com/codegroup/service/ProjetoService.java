package br.com.codegroup.service;

import br.com.codegroup.model.Projeto;
import br.com.codegroup.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService implements IProjetoService {

    @Autowired
    private ProjetoRepository repository;

	@Override
    public List<Projeto> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Projeto> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void saveOrUpdate(Projeto projeto) {
        repository.save(projeto);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}