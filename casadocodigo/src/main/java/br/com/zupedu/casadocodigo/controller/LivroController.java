package br.com.zupedu.casadocodigo.controller;

import br.com.zupedu.casadocodigo.dto.NovoLivroRequest;
import br.com.zupedu.casadocodigo.modelo.Livro;
import br.com.zupedu.casadocodigo.repositories.AutorRepository;
import br.com.zupedu.casadocodigo.repositories.CategoriaRepository;
import br.com.zupedu.casadocodigo.repositories.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;


@RestController
@RequestMapping("/livros")
public class LivroController {


    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    private LivroRepository livroRepository;


    @PostMapping
    @Transactional
    public ResponseEntity<?> criar(@RequestBody @Valid NovoLivroRequest request) {

        Livro livro = request.toModel(entityManager);
        livroRepository.save(livro);
        return ResponseEntity.ok().build();
    }

}
