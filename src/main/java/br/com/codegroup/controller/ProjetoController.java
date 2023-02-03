package br.com.codegroup.controller;

import br.com.codegroup.model.Projeto;
import br.com.codegroup.service.IPessoaService;
import br.com.codegroup.service.IProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    private List<String> LISTA_STATUS_NAO_PODE_DELETAR = Arrays.asList("INICIADO", "EM ANDAMENTO", "ENCERRADO");

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/listar-projeto", method = RequestMethod.GET)
    public String listarProjetos(ModelMap model) {
        model.put("projetos", service.findAll());

        return "listar-projeto";
    }

    @RequestMapping(value = "/novo-projeto", method = RequestMethod.GET)
    public String novoProjeto(ModelMap model) {
        model.addAttribute("listaGerentes", servicePessoa.listaFuncionarios());
        model.addAttribute("projeto", new Projeto());

        return "projeto";
    }

    @RequestMapping(value = "/novo-projeto", method = RequestMethod.POST)
    public String novoProjeto(@Valid Projeto projeto, BindingResult result) {
        if (result.hasErrors()) {
            return "projeto";
        }
        service.saveOrUpdate(projeto);

        return "redirect:/listar-projeto";
    }

    @RequestMapping(value = "/update-projeto", method = RequestMethod.GET)
    public String updateProjeto(ModelMap model, @RequestParam Long id) {
        Projeto projeto = service.findById(id).get();
        service.saveOrUpdate(projeto);
        model.addAttribute("listaGerentes", servicePessoa.listaFuncionarios());
        model.addAttribute("gerente", projeto.getGerente());
        model.put("projeto", projeto);

        return "projeto";
    }

    @RequestMapping(value = "/update-projeto", method = RequestMethod.POST)
    public String updateProjeto(ModelMap model, @Valid Projeto projeto, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("listaGerentes", servicePessoa.listaFuncionarios());
            model.addAttribute("gerente", projeto.getGerente());
            return "projeto";
        }
        service.saveOrUpdate(projeto);

        return "redirect:/listar-projeto";
    }

    @RequestMapping(value = "/delete-projeto", method = RequestMethod.GET)
    public String deleteProjeto(ModelMap model, @RequestParam Long id) {
        Projeto projeto = service.findById(id).get();
        if (LISTA_STATUS_NAO_PODE_DELETAR.contains(projeto.getStatus())) {
            model.addAttribute("showMsgErro", "Não é possível deletar projeto com esse status: " + projeto.getStatus());
        } else {
            service.deleteById(id);
        }
        model.put("projetos", service.findAll());

        return "listar-projeto";
    }
}
