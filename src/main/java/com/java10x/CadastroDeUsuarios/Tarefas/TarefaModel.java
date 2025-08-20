package com.java10x.CadastroDeUsuarios.Tarefas;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java10x.CadastroDeUsuarios.Usuarios.UsuarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "td_tarefas")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class TarefaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cria os Ids
    private Long id;

    private String nome;
    private String dificuldade;

    // Uma tarefa pode ter mais de um usuario
    @OneToMany(mappedBy = "tarefas")
    @JsonIgnore
    private List<UsuarioModel> usuarios;
}
