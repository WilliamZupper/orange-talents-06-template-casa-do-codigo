package br.com.zupedu.casadocodigo.dto;

import br.com.zupedu.casadocodigo.modelo.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorResquet {
    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public NovoAutorResquet(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {

        return new Autor(this.nome, this.email, this.descricao);
    }


}
