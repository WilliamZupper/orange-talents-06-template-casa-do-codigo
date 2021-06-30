package br.com.zupedu.casadocodigo.repositories;

import br.com.zupedu.casadocodigo.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {




}
