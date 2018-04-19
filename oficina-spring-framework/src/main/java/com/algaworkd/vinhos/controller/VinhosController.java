package com.algaworkd.vinhos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworkd.vinhos.model.entity.TipoVinho;
import com.algaworkd.vinhos.model.entity.Vinho;
import com.algaworkd.vinhos.model.service.VinhosService;

@Controller
@RequestMapping("/vinhos")
public class VinhosController {
	
	@Autowired
	private VinhosService service;
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("vinhos/editar-vinho");
		mv.addObject("vinho", getService().buscarPorId(id));
		mv.addObject("tipos", TipoVinho.values());	
		return mv;
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Vinho vinho) {
		ModelAndView mv = new ModelAndView("vinhos/cadastro-vinho");
		mv.addObject("vinho", vinho);
		mv.addObject("tipos", TipoVinho.values());	
		return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("vinhos/lista-vinhos");
		mv.addObject("vinhos", getService().listarTodos());	
		return mv;
	}
	
	
	@PostMapping("/salvar")
	public ModelAndView salvar(@Valid Vinho vinho, BindingResult bindingResult, RedirectAttributes attributes) {
		if (bindingResult.hasErrors()) {
			return novo(vinho);
		}
		getService().salvar(vinho);
		
		attributes.addFlashAttribute("messageSuccess", "Vinho salvo com sucesso!");
		
		return new ModelAndView("redirect:/vinhos/novo");
	}
	
	@PostMapping("/remover")
	public ModelAndView remover(@Valid Vinho vinho, BindingResult bindingResult, RedirectAttributes attributes) {
		if (bindingResult.hasErrors()) {
			return novo(vinho);
		}
		getService().salvar(vinho);
		
		attributes.addFlashAttribute("messageSuccess", "Vinho salvo com sucesso!");
		
		return new ModelAndView("redirect:/vinhos/novo");
	}
	
	public VinhosService getService() {
		return service;
	}
	
	public void setService(VinhosService service) {
		this.service = service;
	}
}
