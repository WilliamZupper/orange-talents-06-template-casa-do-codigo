package br.com.zupedu.casadocodigo.controller;

import br.com.zupedu.casadocodigo.dto.ListaLivroResponse;
import br.com.zupedu.casadocodigo.modelo.Livro;
import br.com.zupedu.casadocodigo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ListaLivroController {

;

    @Autowired
    private LivroRepository livroRepository;

@GetMapping("/livros")
 public List<ListaLivroResponse> lista(){

     List<Livro> livros = livroRepository.findAll();
     return ListaLivroResponse.toModel(livros);





    }



}


