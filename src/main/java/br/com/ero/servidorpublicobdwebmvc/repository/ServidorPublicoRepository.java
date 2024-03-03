package br.com.ero.servidorpublicobdwebmvc.repository;


import br.com.ero.servidorpublicobdwebmvc.entity.ServidorPublico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServidorPublicoRepository extends CrudRepository<ServidorPublico, Long> {
}
