package br.com.zupedu.casadocodigo.controller;

import br.com.zupedu.casadocodigo.dto.NovoAutorRequest;
import br.com.zupedu.casadocodigo.modelo.Autor;
import br.com.zupedu.casadocodigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;


    @PostMapping
    @Transactional
public ResponseEntity<Void>criar(@RequestBody @Valid NovoAutorRequest resquet){
  Autor autor = resquet.toModel();
      autorRepository.save(autor);

    return ResponseEntity.ok().build();

}


}

