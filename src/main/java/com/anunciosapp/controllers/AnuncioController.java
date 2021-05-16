package com.anunciosapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.anunciosapp.models.Anuncio;
import com.anunciosapp.repository.AnuncioRepository;

/** Classe Controller para o Anuncio*/
@Controller
public class AnuncioController {
	

	@Autowired
	private AnuncioRepository er;
	/** Exibe a tela de cadastrar anúncio */
	@RequestMapping(value="/cadastrarAnuncio", method=RequestMethod.GET)
	public String form(){
		
		return "anuncio/formAnuncio";
	}
	/** Verifica se o usuário preencheu todas as informações do cadastro de anúncio, e informa uma mensagem de sucesso ou uma atenção para digitar os campos */
	@RequestMapping(value="/cadastrarAnuncio", method=RequestMethod.POST)
	public String form(@Valid Anuncio anuncio, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Atenção, Informe Todos os Campos!");
			return "redirect:/cadastrarAnuncio";
		}
		er.save(anuncio);
		attributes.addFlashAttribute("mensagem", "Anuncio Cadastrado com Sucesso!");
		return "redirect:/cadastrarAnuncio";
	
	}
	


	
}
