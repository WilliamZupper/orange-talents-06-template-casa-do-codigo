package br.com.zupedu.casadocodigo.repositories;

import br.com.zupedu.casadocodigo.modelo.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PaisRepository extends JpaRepository<Pais , Long> {



}
