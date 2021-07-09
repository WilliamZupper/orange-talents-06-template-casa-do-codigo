package br.com.zupedu.casadocodigo.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pais {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "pais")
    private List<Estado> estados = new ArrayList<>();

    public Pais(String nome) {
        this.nome = nome;
    }

     @Deprecated
    public Pais() {
    }



}
