package br.com.codegroup.controller;

import br.com.codegroup.dto.ProjetoDto;
import br.com.codegroup.service.IPessoaService;
import br.com.codegroup.service.IProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class ProjetoController {

    @Autowired
    private IProjetoService service;

    @Autowired
    private IPessoaService servicePessoa;

    private static final List<String> LISTA_STATUS_NAO_PODE_DELETAR = Arrays.asList("INICIADO", "EM ANDAMENTO", "ENCERRADO");

    private static final String LISTAR_PROJETO = "listar-projeto";

    private static final String LISTA_GERENTES = "listaGerentes";

    private static final String GERENTE = "gerente";

    private static final String PROJETO = "projeto";

    private static final String PROJETOS = "projetos";

    private static final String REDIRECT = "redirect:/";

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping(value = "/listar-projeto")
    public String listarProjetos(ModelMap model) {
        model.put(PROJETOS, service.findAll());

        return LISTAR_PROJETO;
    }

    @GetMapping(value = "/novo-projeto")
    public String novoProjeto(ModelMap model) {
        model.addAttribute(LISTA_GERENTES, servicePessoa.listaFuncionarios());
        model.addAttribute(PROJETO, new ProjetoDto());

        return PROJETO;
    }

    @PostMapping(value = "/novo-projeto")
    public String novoProjeto(@ModelAttribute("projeto") @Valid ProjetoDto projetoDto, BindingResult result) {
        if (result.hasErrors()) {
            return PROJETO;
        }

        service.saveOrUpdate(projetoDto);

        return REDIRECT + LISTAR_PROJETO;
    }

    @GetMapping(value = "/update-projeto")
    public String updateProjeto(ModelMap model, @RequestParam Long id) {
        ProjetoDto projetoDto = service.findById(id);

        if (projetoDto != null) {
            service.saveOrUpdate(projetoDto);
            model.addAttribute(LISTA_GERENTES, servicePessoa.listaFuncionarios());
            model.addAttribute(GERENTE, projetoDto.getGerente());
            model.put(PROJETO, projetoDto);
        }

        return PROJETO;
    }

    @PostMapping(value = "/update-projeto")
    public String updateProjeto(ModelMap model, @ModelAttribute("projeto") @Valid ProjetoDto projetoDto, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(LISTA_GERENTES, servicePessoa.listaFuncionarios());
            model.addAttribute(GERENTE, projetoDto.getGerente());
            return PROJETO;
        }

        service.saveOrUpdate(projetoDto);

        return REDIRECT + LISTAR_PROJETO;
    }

    @GetMapping(value = "/delete-projeto")
    public String deleteProjeto(ModelMap model, @RequestParam Long id) {
        ProjetoDto projetoDto = service.findById(id);

        if (projetoDto != null) {
            if (LISTA_STATUS_NAO_PODE_DELETAR.contains(projetoDto.getStatus())) {
                model.addAttribute("showMsgErro", "Não é possível deletar projeto com esse status: " + projetoDto.getStatus());
            } else {
                service.deleteById(id);
            }
            model.put(PROJETOS, service.findAll());
        }

        return LISTAR_PROJETO;
    }
}
