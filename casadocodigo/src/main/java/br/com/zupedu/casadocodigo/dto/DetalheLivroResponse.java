package br.com.zupedu.casadocodigo.dto;

import br.com.zupedu.casadocodigo.modelo.Livro;


import java.math.BigDecimal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DetalheLivroResponse {

    private DetalheAutorResponse autor;

    private String titulo;


    private String sumario;


    private String resumo;

    private BigDecimal preco;


    private Integer numeroPaginas;


    private String isbn;


    private String dataLancamento;


    public DetalheLivroResponse(Livro livro) {
        titulo = livro.getTitulo();
        autor = new DetalheAutorResponse(livro.getAutor());
        sumario = livro.getSumario();
        resumo = livro.getResumo();
        preco = livro.getPreco();
        numeroPaginas = livro.getNumeroPaginas();
        isbn = livro.getIsbn();
        dataLancamento = livro.getDataLancamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));


    }


    public String getTitulo() {
        return titulo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getResumo() {
        return resumo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public DetalheAutorResponse getAutor() {
        return autor;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }
}