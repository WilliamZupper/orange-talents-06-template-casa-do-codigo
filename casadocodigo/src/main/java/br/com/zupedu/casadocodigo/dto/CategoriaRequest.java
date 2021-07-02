package br.com.zupedu.casadocodigo.dto;

import br.com.zupedu.casadocodigo.modelo.Categoria;


import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
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
