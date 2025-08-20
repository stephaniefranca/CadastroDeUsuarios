package com.java10x.CadastroDeUsuarios.Usuarios;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

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
    public ResponseEntity<String> criarUsuario(@RequestBody UsuarioDTO usuario){
        UsuarioDTO usuarioNovo = usuarioService.criarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario criado com sucesso! " + usuarioNovo.getNome() + " (ID)8: " + usuarioNovo.getId());
    }

    // Mostrar todos os user (read)
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios(){
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    //Mostrar user por ID (read)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarUsuariosPorId(@PathVariable Long id){
        UsuarioDTO usuario = usuarioService.listarUsuariosPorId(id);
        if (usuario != null){
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario com id " + id + " não existe no nosso banco de dados.");
        }
    }

    // Alterar dados do user (update)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioAtualizado){
         UsuarioDTO usuario = usuarioService.atualizarUsuario(id, usuarioAtualizado);
         if (usuario != null){
             return ResponseEntity.ok(usuario);
         } else {
             return ResponseEntity.status(HttpStatus.NOT_FOUND)
                     .body("Usuario com id " + id + " não existe no nosso banco de dados.");
         }
    }

    //Deletar user (delete)
    @DeleteMapping("/deletar/{id}")
        public ResponseEntity<String> deletarUsuariosPorId(@PathVariable Long id){

            if (usuarioService.listarUsuariosPorId(id) != null){
                usuarioService.deletarUsuariosPorId(id);
                return ResponseEntity.ok("Usuario de ID: " + id + " deletado com sucesso!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Usuario com id " + id + " não encontrado.");
            }
    }
}
