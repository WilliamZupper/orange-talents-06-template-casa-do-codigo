package br.com.zupedu.casadocodigo.controller;

import br.com.zupedu.casadocodigo.dto.NovoPaisRequest;
import br.com.zupedu.casadocodigo.modelo.Pais;
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
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?>criar(@RequestBody @Valid NovoPaisRequest request){

       Pais pais = request.toModel();

       paisRepository.save(pais);


         return ResponseEntity.ok().build();
    }
}
