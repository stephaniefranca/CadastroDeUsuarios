package com.java10x.CadastroDeUsuarios.Tarefas;
import com.java10x.CadastroDeUsuarios.Usuarios.UsuarioModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "td_tarefas")
public class TarefaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    // Uma tarefa pode ter mais de um usuario
    @OneToMany(mappedBy = "tarefas")
    private List<UsuarioModel> usuarios;
}
