package br.com.zupedu.casadocodigo.modelo;

import javax.persistence.*;

@Entity
public class Estado {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

     @ManyToOne
    private Pais pais;

      @Deprecated
    public Estado() {
    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }



}
