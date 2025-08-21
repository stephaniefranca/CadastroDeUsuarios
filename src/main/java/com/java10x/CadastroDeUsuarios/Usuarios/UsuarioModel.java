package com.java10x.CadastroDeUsuarios.Usuarios;
import com.java10x.CadastroDeUsuarios.Tarefas.TarefaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "tarefas")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cria os Ids
    @Column(name = "ID") // nome da coluna
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "idade")
    private int idade;

    @Column(name = "rank")
    private String rank;


    // Um usuario so pode estar atribuito a uma unica tarefa
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tarefas_id") // cria uma coluna para a chave estrangeira
    private TarefaModel tarefas;


}