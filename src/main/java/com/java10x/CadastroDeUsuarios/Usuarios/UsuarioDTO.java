package com.java10x.CadastroDeUsuarios.Usuarios;

import com.java10x.CadastroDeUsuarios.Tarefas.TarefaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioDTO {

    private Long id;

    private String nome;

    private String email;

    private String imgUrl;

    private int idade;

    private String rank;

    private TarefaModel tarefas;


}
