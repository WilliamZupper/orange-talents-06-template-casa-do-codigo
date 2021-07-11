package br.com.zupedu.casadocodigo.dto;


import br.com.zupedu.casadocodigo.modelo.Autor;
import br.com.zupedu.casadocodigo.modelo.Categoria;
import br.com.zupedu.casadocodigo.modelo.Livro;
import br.com.zupedu.casadocodigo.validacao.CheckId;
import br.com.zupedu.casadocodigo.validacao.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroRequest {
    @NotBlank
    @UniqueValue(Classe = Livro.class, campo = "titulo")
    @JsonProperty
    private String titulo;

    @NotBlank
    @JsonProperty
    private String sumario;

    @NotBlank
    @JsonProperty
    @Size(max = 500)
    private String resumo;

    @Min(value = 20)
    @NotNull
    @JsonProperty
    private BigDecimal preco;

    @Min(value = 100)
    @NotNull
    @JsonProperty
    private Integer numeroPaginas;

    @NotBlank
    @UniqueValue(Classe = Livro.class, campo = "isbn")
    @JsonProperty
    private String isbn;

     @Future
     @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING )
     @NotNull
    private LocalDate dataLancamento;

    @JsonProperty
    @NotNull
    @CheckId(Classe = Categoria.class, campo = "id")

    private Long categoria;
    @JsonProperty
    @NotNull
     @CheckId(Classe = Autor.class, campo = "id")
    private Long autor;

    public NovoLivroRequest() {
    }

    public NovoLivroRequest(@NotBlank String titulo, @NotBlank String sumario, @NotBlank @Size(max = 500) String resumo, @Min(value = 20) @NotNull BigDecimal preco, @Min(value = 100) @NotNull Integer numeroPaginas,
                            @NotBlank String isbn, @Future LocalDate dataLancamento, Long categoria, Long autor) {
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




    public Livro toModel(EntityManager entityManager) {

        Autor a = entityManager.find(Autor.class, autor);
        Categoria c = entityManager.find(Categoria.class, categoria);
        Assert.state(autor!=null, "Você esta querendo cadastrar um livro para um autor que não exite no banco " + a);
        Assert.state(categoria!=null, "Você esta querendo cadastrar um livro para uma categoria que não exite no banco" + c);


        return new Livro(titulo, sumario, resumo, preco, numeroPaginas, isbn, dataLancamento, c, a);
    }



     /* Criei esse setter pq o Jackson não estava sendo capaz de
     desserializar o json com a data no parâmetro pelo construtor.
      */
    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }


}