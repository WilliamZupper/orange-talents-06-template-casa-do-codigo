package br.com.zupedu.casadocodigo.dto;

import br.com.zupedu.casadocodigo.modelo.Autor;

public class DetalheAutorResponse {
    private String nome;
    private String descricao;


    public DetalheAutorResponse(Autor autor) {
        nome = autor.getNome();
        descricao = autor.getDescricao();
    }


    public String getNome() {
        return nome;
    }


    public String getDescricao() {
        return descricao;
    }

}
