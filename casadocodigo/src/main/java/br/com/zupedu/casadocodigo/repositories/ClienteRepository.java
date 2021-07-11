package br.com.zupedu.casadocodigo.repositories;

import br.com.zupedu.casadocodigo.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
