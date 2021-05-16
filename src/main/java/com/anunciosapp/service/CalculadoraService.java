package com.anunciosapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

/** Classe com as regras de negócios */
@Service
public class CalculadoraService {
	
	/** Metodo que recebe duas datas e calcula o periodo de dias do anúncio */
	public long calcularQtdDias(String dataInicio, String dataFim) throws ParseException {
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dataFormatadaIni = formato.parse(dataInicio); 
		Date dataFormatadaFim = formato.parse(dataFim); 
		
		long diffInMillies = Math.abs(dataFormatadaFim.getTime() - dataFormatadaIni.getTime());
		long diferencaDias = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		
		
		
		return diferencaDias+1;
	}
		
	/** Metodo que recebe o investimento e calcula a quantidade máxima de visualizações que este anúncio vai ter */
	public int calcularAlcanceAnuncio(int investimentoDia) {
		int alcanceCalculado = 0;
		double visualizacoes;

		visualizacoes = (investimentoDia * 30);

		alcanceCalculado = (int) visualizacoes;

		for (int i = 0; i < 3; i++) {
			double numeroCliques = 0;
			double numeroCompartilhamento = 0;
			numeroCliques = (visualizacoes * 0.12);
			numeroCompartilhamento = (numeroCliques * 0.15);
			visualizacoes = (numeroCompartilhamento * 40);
			alcanceCalculado = (int) (alcanceCalculado + visualizacoes);

		}

		return alcanceCalculado;
	}
	/** Metodo que recebe o investimento e calcula quantidade máxima de compartilhamentos que este anúncio vai ter */
	public int calcularCompartilhamentos(int investimentoDia) {
		int totalCompartilhamento = 0;
		double visualizacoes;

		visualizacoes = (investimentoDia * 30);

		for (int i = 0; i < 3; i++) {
			double numeroCliques = 0;
			double numeroCompartilhamento = 0;
			numeroCliques = (visualizacoes * 0.12);
			numeroCompartilhamento = (numeroCliques * 0.15);
			totalCompartilhamento = (int) (totalCompartilhamento + numeroCompartilhamento);

		}

		return totalCompartilhamento;
	}
	/** Metodo que recebe o investimento e calcula quantidade quantidade máxima de cliques que este anúncio vai ter */
	public int calcularCliques(int investimentoDia) {
		int totalCliques = 0;
		double visualizacoes;

		visualizacoes = (investimentoDia * 30);

		for (int i = 0; i < 3; i++) {
			double numeroCliques = 0;
			double numeroCompartilhamento = 0;
			numeroCliques = (visualizacoes * 0.12);
			totalCliques = (int) (totalCliques + numeroCliques);
			numeroCompartilhamento = (numeroCliques * 0.15);
			visualizacoes = (numeroCompartilhamento * 40);

		}

		return totalCliques;
	}

}
