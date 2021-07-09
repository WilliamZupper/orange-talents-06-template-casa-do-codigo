package br.com.zupedu.casadocodigo.dto;

import br.com.zupedu.casadocodigo.modelo.Estado;
import br.com.zupedu.casadocodigo.modelo.Pais;
import br.com.zupedu.casadocodigo.repositories.PaisRepository;
import br.com.zupedu.casadocodigo.validacao.CheckId;
import br.com.zupedu.casadocodigo.validacao.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class NovoEstadoRequest {

     @NotBlank
     @UniqueValue(Classe = Estado.class, campo = "nome")
    private String nome;


     @NotNull
     @CheckId(Classe = Pais.class, campo = "id")
    private Long  pais;

    public NovoEstadoRequest( @NotBlank String nome, @NotNull Long pais) {
        this.nome = nome;

        this.pais = pais;
    }


    public Estado toModel(PaisRepository paisRepository) {

       Optional<Pais>pais = paisRepository.findById(this.pais);

       return new Estado(this.nome, pais.get());
    }
}
