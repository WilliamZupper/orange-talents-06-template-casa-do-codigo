package br.com.zupedu.casadocodigo.controller;

import br.com.zupedu.casadocodigo.dto.NovoClienteRequest;
import br.com.zupedu.casadocodigo.modelo.Cliente;
import br.com.zupedu.casadocodigo.repositories.ClienteRepository;
import br.com.zupedu.casadocodigo.repositories.EstadoRepository;
import br.com.zupedu.casadocodigo.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

            @Autowired
    PaisRepository paisRepository;

            @Autowired
    EstadoRepository estadoRepository;

            @Autowired
            ClienteRepository clienteRepository;

      @PostMapping
    public ResponseEntity<?>criar(@RequestBody @Valid NovoClienteRequest request){

        Cliente cliente = request.toModel(paisRepository, estadoRepository);

         clienteRepository.save(cliente);



        return ResponseEntity.ok(cliente);



    }
}
