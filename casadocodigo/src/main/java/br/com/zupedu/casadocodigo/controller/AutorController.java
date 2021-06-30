package br.com.zupedu.casadocodigo.controller;

import br.com.zupedu.casadocodigo.dto.NovoAutorResquet;
import br.com.zupedu.casadocodigo.modelo.Autor;
import br.com.zupedu.casadocodigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @PostMapping
public ResponseEntity<?>criar(@RequestBody @Valid NovoAutorResquet resquet){
  Autor autor = resquet.toModel();
      autorRepository.save(autor);

    return ResponseEntity.ok().body(autor);

}


}

