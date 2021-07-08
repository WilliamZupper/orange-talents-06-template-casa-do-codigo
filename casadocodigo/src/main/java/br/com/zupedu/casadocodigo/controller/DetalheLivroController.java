package br.com.zupedu.casadocodigo.controller;

import br.com.zupedu.casadocodigo.dto.DetalheLivroResponse;
import br.com.zupedu.casadocodigo.modelo.Livro;
import br.com.zupedu.casadocodigo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@RestController
public class DetalheLivroController {



    @PersistenceContext
    private EntityManager manager;

    @GetMapping(value = "/livros/{id}")
    public ResponseEntity<?> detalhe(@PathVariable("id") Long id){

         Livro livroBuscado = manager.find(Livro.class, id);

           if(livroBuscado == null){
               return ResponseEntity.notFound().build();
           }

            DetalheLivroResponse detalheLivroResponse = new DetalheLivroResponse(livroBuscado);

      return ResponseEntity.ok(detalheLivroResponse);





    }
}
