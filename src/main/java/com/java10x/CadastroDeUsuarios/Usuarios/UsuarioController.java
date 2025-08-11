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
    public UsuarioModel criarUsuario(@RequestBody UsuarioModel usuario){
        return usuarioService.criarUsuario(usuario);
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
    @PutMapping("/alterar/{id}")
    public UsuarioModel atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuarioAtualizado){
        return usuarioService.atualizarUsuario(id, usuarioAtualizado);
    }

    //Deletar user (delete)
    @DeleteMapping("/deletar/{id}")
        public void deletarUsuariosPorId(@PathVariable Long id){
            usuarioService.deletarUsuariosPorId(id);
    }
}
