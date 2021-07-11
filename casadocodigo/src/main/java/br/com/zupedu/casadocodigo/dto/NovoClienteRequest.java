package br.com.zupedu.casadocodigo.dto;

import br.com.zupedu.casadocodigo.modelo.Cliente;
import br.com.zupedu.casadocodigo.modelo.Estado;
import br.com.zupedu.casadocodigo.modelo.Pais;
import br.com.zupedu.casadocodigo.repositories.EstadoRepository;
import br.com.zupedu.casadocodigo.repositories.PaisRepository;
import br.com.zupedu.casadocodigo.validacao.CPF_CNPJ;
import br.com.zupedu.casadocodigo.validacao.CheckId;
import br.com.zupedu.casadocodigo.validacao.UniqueValue;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class NovoClienteRequest {


    @NotBlank
    @UniqueValue(Classe = Cliente.class, campo = "email")
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

     @CPF_CNPJ
     @NotBlank
     @UniqueValue(Classe = Cliente.class, campo = "documento")
    private String documento;

     @NotNull
     @NotEmpty
    private String endereco;

    @NotNull
    @NotEmpty
    private String complemento;
    @NotNull
    @NotEmpty
    private String cidade;

    @NotNull
    @CheckId(Classe = Pais.class, campo = "id")
    private Long pais;

    @CheckId(Classe = Estado.class, campo = "id")

    private Long estado;


    @NotNull
    @NotEmpty
    private String telefone;
    @NotNull
    @NotEmpty
    private String cep;


    public NovoClienteRequest(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Long pais, Long estado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }


    public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository) {


        Optional<Pais> pais = paisRepository.findById(this.pais);

        Estado estadoInstance = null;

        if (this.estado != null) {
            estadoInstance = estadoRepository.findById(this.estado).get();
        }


        return new Cliente(this.email,
                this.nome,
                this.sobrenome,
                this.documento,
                this.endereco,
                this.complemento,
                this.cidade,
                pais.get(),
                estadoInstance,
                this.telefone,
                this.cep);
    }


}
