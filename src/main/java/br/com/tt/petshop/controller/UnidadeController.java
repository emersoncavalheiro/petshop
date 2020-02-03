package br.com.tt.petshop.controller;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.service.UnidadeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UnidadeController {

    private UnidadeService unidadeService;

    public UnidadeController(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }


    @RequestMapping("/admin/unidade/cadastrar")
    public String cadastrar(){
        return "/unidade/cadastrar";
    }

    @RequestMapping("/admin/unidade/salvar")
    public String salvar(Unidade unidade, Model model){
        this.unidadeService.criar(unidade);
        return "redirect:/admin/unidade/listar";

    }

    @RequestMapping("/admin/unidade/listar")
    public String listar(Model model){
        List<Unidade> unidades = this.unidadeService.listar();
        model.addAttribute("unidades" , unidades);
        return "/unidade/listar";
    }

    @RequestMapping("/admin/unidade/excluir")
    public String excluir(@RequestParam String nome , Model model){
        this.unidadeService.excluir(nome);
        return "/unidade/listar";

    }

}
