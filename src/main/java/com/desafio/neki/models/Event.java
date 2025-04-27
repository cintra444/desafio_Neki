package com.desafio.neki.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Arrays;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String description;
    private LocalDate data;
    private String localizacao;

    @Lob
    private byte[] imagem;

    @ManyToOne
    private Admin adminId;

    public Event() {}

    public Event(Long id, String nome, LocalDate data,String description, String localizacao, byte[] imagem, Admin adminId) {
        this.id = id;
        this.nome = nome;
        this.description = description;
        this.data = data;
        this.localizacao = localizacao;
        this.imagem = imagem;
        this.adminId = adminId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Admin getAdminId() {
        return adminId;
    }

    public void setAdminId(Admin adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", description='" + description + '\'' +
                ", data=" + data +
                ", localizacao='" + localizacao + '\'' +
                ", imagem=" + Arrays.toString(imagem) +
                ", adminId=" + adminId +
                '}';
    }
}
