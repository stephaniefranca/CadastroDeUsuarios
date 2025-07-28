package com.java10x.CadastroDeUsuarios;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro")
public class UsuarioModel {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    int idade;

    public UsuarioModel() {
    }

    public UsuarioModel(int idade, String email, String nome) {
        this.idade = idade;
        this.email = email;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
