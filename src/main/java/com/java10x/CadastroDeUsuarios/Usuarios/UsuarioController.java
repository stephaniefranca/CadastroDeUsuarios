package com.java10x.CadastroDeUsuarios.Usuarios;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

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
    @GetMapping("/listar")
    public List<UsuarioModel> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    //Mostrar user por ID (read)
    @GetMapping("/listar/{id}")
    public UsuarioModel listarUsuariosPorId(@PathVariable Long id){
        return usuarioService.listarUsuariosPorId(id);
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
