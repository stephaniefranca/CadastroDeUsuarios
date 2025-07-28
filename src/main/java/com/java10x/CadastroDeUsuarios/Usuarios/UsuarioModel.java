package com.java10x.CadastroDeUsuarios.Usuarios;

import com.java10x.CadastroDeUsuarios.Tarefas.TarefaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String email;
    private int idade;

    // Um usuario so pode estar atribuito a uma unica tarefa
    @ManyToOne
    @JoinColumn(name = "tarefas_id") // cria uma coluna para a chave estrangeira
    private TarefaModel tarefas;

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
