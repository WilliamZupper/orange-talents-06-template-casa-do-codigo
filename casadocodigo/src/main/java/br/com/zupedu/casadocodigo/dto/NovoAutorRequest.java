package br.com.zupedu.casadocodigo.dto;

import br.com.zupedu.casadocodigo.modelo.Autor;
import br.com.zupedu.casadocodigo.validacao.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorRequest {
    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @UniqueValue(Classe = Autor.class,campo = "email")
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public NovoAutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {

        return new Autor(this.nome, this.email, this.descricao);
    }


    public String getEmail() {
        return this.email;
    }
}
