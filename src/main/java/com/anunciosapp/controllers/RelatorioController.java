package com.anunciosapp.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anunciosapp.models.Anuncio;
import com.anunciosapp.models.Relatorio;
import com.anunciosapp.repository.AnuncioRepository;
import com.anunciosapp.service.CalculadoraService;

/** Classe Controle para o Relatório */
@Controller
public class RelatorioController {

	@Autowired
	private AnuncioRepository er;
	
	@Autowired
	private CalculadoraService calculadoraService;
	
	/** Exibe lista com todos os anúncios e as informações calculadas do relatório */
	@RequestMapping("/relatorioAnuncio")
	public ModelAndView listarRelatoriosAnuncios() throws ParseException {
		ModelAndView mv = new ModelAndView("listaAnuncios");
		List<Relatorio> relatorios = new ArrayList();
		Iterable<Anuncio> anuncios = er.findAll();
		for (Anuncio anuncio : anuncios) {
			Relatorio relatorio = new Relatorio();
			relatorio.setAnuncio(anuncio);
			int qtdDias=(int) calculadoraService.calcularQtdDias(anuncio.getDataInicio(), anuncio.getDataTermino());
			int valorTotal = qtdDias * Integer.parseInt(anuncio.getInvestimentoDia());
			relatorio.setInvestimentoTotal(""+valorTotal);
			relatorio.setTotalCliques(""+calculadoraService.calcularCliques(valorTotal));
			relatorio.setTotalCompartilhamentos(""+calculadoraService.calcularCompartilhamentos(valorTotal));
			relatorio.setValorAlcance(""+calculadoraService.calcularAlcanceAnuncio(valorTotal));
			relatorios.add(relatorio);
		}
		mv.addObject("relatorios", relatorios);
		
		return mv;
	}
	
	/** Filtro de relatorio por cliente e data */	
	@PostMapping("**/pesquisarAnuncio")
	public ModelAndView pesquisar(@RequestParam("nomepesquisa") String nomepesquisa, String datapesquisa) throws ParseException {		
		ModelAndView mv = new ModelAndView("listaAnuncios");
		List<Relatorio> relatorios = new ArrayList();
		Iterable<Anuncio> anuncios = er.findAnuncioByNameDate(nomepesquisa, datapesquisa);
		for (Anuncio anuncio : anuncios) {
			Relatorio relatorio = new Relatorio();
			relatorio.setAnuncio(anuncio);
			int qtdDias=(int) calculadoraService.calcularQtdDias(anuncio.getDataInicio(), anuncio.getDataTermino());
			int valorTotal = qtdDias * Integer.parseInt(anuncio.getInvestimentoDia());
			relatorio.setInvestimentoTotal(""+valorTotal);
			relatorio.setTotalCliques(""+calculadoraService.calcularCliques(valorTotal));
			relatorio.setTotalCompartilhamentos(""+calculadoraService.calcularCompartilhamentos(valorTotal));
			relatorio.setValorAlcance(""+calculadoraService.calcularAlcanceAnuncio(valorTotal));
			relatorios.add(relatorio);
		}
		mv.addObject("relatorios", relatorios);
		
		return mv;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
