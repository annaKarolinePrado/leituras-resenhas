package com.leiturasresenhas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.crypto.Data;
import java.time.LocalDateTime;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String autor;
    private String genero;
    private String dataPublicacao;
    private String editora;
    private String avaliacao;
    private String opiniaoResenha;
    private boolean status;
    private LocalDateTime dataLeitura;
    private LocalDateTime dataPrevistaLeitura;

    public Livro() {
    }

    public Livro(Long id,
                 String titulo,
                 String autor,
                 String genero,
                 String dataPublicacao,
                 String editora,
                 String avaliacao,
                 String opiniaoResenha,
                 boolean status,
                 LocalDateTime dataLeitura,
                 LocalDateTime dataPrevistaLeitura) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.dataPublicacao = dataPublicacao;
        this.editora = editora;
        this.avaliacao = avaliacao;
        this.opiniaoResenha = opiniaoResenha;
        this.status = status;
        this.dataLeitura = dataLeitura;
        this.dataPrevistaLeitura = dataPrevistaLeitura;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }
    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getEditora() {
        return editora;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAvaliacao() {
        return avaliacao;
    }
    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getOpiniaoResenha() {
        return opiniaoResenha;
    }
    public void setOpiniaoResenha(String opiniaoResenha) {
        this.opiniaoResenha = opiniaoResenha;
    }

    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getDataLeitura() {
        return dataLeitura;
    }
    public void setDataLeitura(LocalDateTime dataLeitura) {
        this.dataLeitura = dataLeitura;
    }

    public LocalDateTime getDataPrevistaLeitura() {
        return dataPrevistaLeitura;
    }
    public void setDataPrevistaLeitura(LocalDateTime dataPrevistaLeitura) {
        this.dataPrevistaLeitura = dataPrevistaLeitura;
    }
}
