package study.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import study.springmvc.daos.ProdutoDAO;
import study.springmvc.model.Produto;
import study.springmvc.model.TipoPreco;

@Controller
public class ProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDAO;

	@RequestMapping("/produtos/formulario")
	public ModelAndView form(){
		System.out.println("/produtos/formulario");
		ModelAndView modelAndView = new ModelAndView("produtos/formulario");
		modelAndView.addObject("tipos", TipoPreco.values());
		return modelAndView;
	}
	
	@RequestMapping("/produtos/cadastrar")
	public String gravar(Produto produto){
		produtoDAO.gravar(produto);
		return ("produtos/cadastrado");
	}
}
