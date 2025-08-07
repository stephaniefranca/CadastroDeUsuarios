package com.java10x.CadastroDeUsuarios.Usuarios;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UsuarioController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Ola! Bem vindo!";
    }

    // CRUD

    // Adicionar user (create)
    @PostMapping("/criar")
    public String criarUsuario(){
        return "Usuario criado";
    }

    // Mostrar todos os user (read)
    @GetMapping("/todos")
    public String mostrarTodoUsuarios(){
        return "Todos usuarios";
    }

    //Mostrar user por ID (read)
    @GetMapping("/todosId")
    public String mostrarTodoUsuariosPorId(){
        return "Usuario Id";
    }

    // Alterar dados do user (update)
    @PutMapping("/alterarId")
    public String alterarUsuarioPorId(){
        return "Alterar usuario po Id";
    }

    //Deletar user (delete)
    @DeleteMapping("/deletarId")
        public String deletarUsuarioPorId(){
            return "Deletar usuario po Id";
    }
}
