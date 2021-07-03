package br.com.zupedu.casadocodigo.controller;

import br.com.zupedu.casadocodigo.dto.CategoriaRequest;
import br.com.zupedu.casadocodigo.modelo.Categoria;
import br.com.zupedu.casadocodigo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {


   @Autowired
   private CategoriaRepository categoriaRepository;




    @PostMapping
    @Transactional
    public ResponseEntity<Void> criar(@RequestBody @Valid CategoriaRequest request) {

        Categoria categoria = request.toCategoria();

        categoriaRepository.save(categoria);

        return ResponseEntity.ok().build();
    }

}