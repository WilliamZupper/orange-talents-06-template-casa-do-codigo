package br.com.zupedu.casadocodigo.dto;

import br.com.zupedu.casadocodigo.modelo.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class ListaLivroResponse {

    private Long id;

    private String titulo;

    public ListaLivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo =livro.getTitulo();
    }

    public static List<ListaLivroResponse> toModel(List<Livro> livros) {
        return livros.stream().map(ListaLivroResponse::new).collect(Collectors.toList());
    }




    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
