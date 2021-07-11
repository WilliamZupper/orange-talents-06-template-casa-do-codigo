package br.com.zupedu.casadocodigo.modelo;

import br.com.zupedu.casadocodigo.validacao.CPF_CNPJ;

import javax.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;


     @Column(unique = true)
    private String documento;

     @Column(nullable = false)
    private String endereco;

     @Column(nullable = false)
    private String complemento;


     @Column(nullable = false)
    private String cidade;


    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String cep;

    public Cliente(String email,
                   String nome,
                   String sobrenome,
                   String documento,
                   String endereco,
                   String complemento,
                   String cidade,
                   Pais pais,
                   Estado estado,
                   String telefone,
                   String cep) {
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
      @Deprecated
    public Cliente() {
    }


    public Long getId() {
        return id;
    }
}


