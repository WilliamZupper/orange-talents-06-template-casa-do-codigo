package br.com.zupedu.casadocodigo.dto;

import br.com.zupedu.casadocodigo.modelo.Categoria;
import br.com.zupedu.casadocodigo.validacao.UniqueValue;


import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @UniqueValue(Classe = Categoria.class, campo = "nome")
    private String nome;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria toCategoria(){

        return new Categoria(this.nome);
      }


}
