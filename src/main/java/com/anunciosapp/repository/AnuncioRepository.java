package com.anunciosapp.repository;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anunciosapp.models.Anuncio;

/** Classe com as consultas do Banco de dados */
@Repository
@Transactional
public interface AnuncioRepository extends CrudRepository<Anuncio, String> {
	/** Consulta anuncio pelo Cliente */
	@Query("select a from Anuncio a where a.cliente like %?1%")
	List<Anuncio> findAnuncioByName(String cliente) ;
	/** Consulta anuncio pelo Cliente e Data */
	@Query("select a from Anuncio a where a.cliente like %?1% and ?2 between dataInicio and dataTermino")
	List<Anuncio> findAnuncioByNameDate(String cliente, String data) ;
	
}
