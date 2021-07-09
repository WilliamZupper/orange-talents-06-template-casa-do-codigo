package br.com.zupedu.casadocodigo.dto;

import br.com.zupedu.casadocodigo.modelo.Pais;
import br.com.zupedu.casadocodigo.validacao.UniqueValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {


    @NotBlank
   @UniqueValue(Classe = Pais.class, campo = "nome")

    String nome;

    public Pais toModel() {

       return new Pais( this.nome);
    }
    /*se faz necessario o uso do set porque Jackson não consequer construir objeto
    pelo construtor tendo somente um campo*/
    public void setNome(String nome) {
        this.nome = nome;
    }
}
