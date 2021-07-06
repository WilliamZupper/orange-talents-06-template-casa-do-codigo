package br.com.zupedu.casadocodigo.modelo;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "livro")
public class Livro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String titulo;

    @Lob
    @Column(nullable = false)
    private String sumario;


    @Column(nullable = false,length = 500)
    private String resumo;

    @Column(nullable = false)
    private BigDecimal preco;


    @Column(nullable = false)
    private Integer numeroPaginas;


    @Column(nullable = false, unique = true)
    private String isbn;

    //@Future
   // @JsonFormat(pattern = "YYYY-MM-dd ", shape = JsonFormat.Shape.STRING)
    @NotNull
    private LocalDate dataLancamento;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Autor autor;

    public Livro(String titulo, String sumario, String resumo, BigDecimal preco, Integer numeroPaginas, String isbn, LocalDate dataLancamento, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.sumario = sumario;
        this.resumo = resumo;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.categoria = categoria;
        this.autor = autor;
    }
    @Deprecated
    public Livro() {
    }


}