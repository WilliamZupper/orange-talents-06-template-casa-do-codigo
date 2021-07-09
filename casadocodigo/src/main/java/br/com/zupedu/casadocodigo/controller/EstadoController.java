package br.com.zupedu.casadocodigo.controller;

import br.com.zupedu.casadocodigo.dto.NovoEstadoRequest;
import br.com.zupedu.casadocodigo.modelo.Estado;
import br.com.zupedu.casadocodigo.repositories.EstadoRepository;
import br.com.zupedu.casadocodigo.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
     private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

     @PostMapping
     @Transactional
    public ResponseEntity<?>criar(@RequestBody @Valid NovoEstadoRequest request){

        Estado estado = request.toModel(paisRepository);

           estadoRepository.save(estado);

        return ResponseEntity.ok().build();
    }


}
