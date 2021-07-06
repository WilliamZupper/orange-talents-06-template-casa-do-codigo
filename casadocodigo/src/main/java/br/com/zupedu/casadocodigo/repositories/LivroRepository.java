package br.com.zupedu.casadocodigo.repositories;

import br.com.zupedu.casadocodigo.modelo.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
