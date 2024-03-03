package br.com.ero.servidorpublicobdwebmvc.service;


import br.com.ero.servidorpublicobdwebmvc.entity.ServidorPublico;

import java.util.List;
import java.util.Optional;

public interface ServidorPublicoService {
	
	List<ServidorPublico> listAll();
	
	Optional<ServidorPublico> listByMatricula(long matricula);
	void save(ServidorPublico servidorPublico);
	void update(ServidorPublico servidorPublico);
	void delete(long matricula);

}
