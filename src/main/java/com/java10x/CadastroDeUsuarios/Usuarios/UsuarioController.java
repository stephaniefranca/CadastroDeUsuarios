package com.java10x.CadastroDeUsuarios.Usuarios;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/boasvindas")
    @Operation (summary = "Mensagem de Boas Vindas", description = "Essa rota retorna uma mensagem de boas vindas para quem acessar.")
    public String boasVindas(){
        return "Ola! Bem vindo!";
    }

    // CRUD para API REST

    // Adicionar user (create)
    @PostMapping("/criar")
    @Operation (summary = "Criar um novo usuario", description = "Essa rota cria um novo usuario e insere no banco de dados.")
    @ApiResponses (value = {
            @ApiResponse (responseCode = "201", description = "Usuario criado com sucesso"),
            @ApiResponse (responseCode = "400", description = "Erro na criação do usuario")
    })
    public ResponseEntity<String> criarUsuario(@RequestBody UsuarioDTO usuario){
        UsuarioDTO usuarioNovo = usuarioService.criarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario criado com sucesso! " + usuarioNovo.getNome() + " (ID): " + usuarioNovo.getId());
    }

    // Mostrar todos os user (read)
    @GetMapping("/listar")
    @Operation (summary = "Lista todos os usuarios", description = "Essa rota lista todos os usuarios cadastrados no banco de dados.")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios(){
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    //Mostrar user por ID (read)
    @GetMapping("/listar/{id}")
    @Operation (summary = "Lista o usuario por ID", description = "Essa rota lista um usuario pelo seu ID")
    @ApiResponses (value = {
            @ApiResponse (responseCode = "200", description = "Usuario encontrado com sucesso"),
            @ApiResponse (responseCode = "404", description = "Usuario não encontrado")
    })
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
    @Operation (summary = "Altera o usuario por ID", description = "Essa rota altera um usuario pelo seu ID")
    @ApiResponses (value = {
            @ApiResponse (responseCode = "200", description = "Usuario alterado com sucesso"),
            @ApiResponse (responseCode = "404", description = "Usuario não encontrado, não é possivel alterar")
    })
    public ResponseEntity<?> atualizarUsuario(
            @Parameter (description = "Usuario manda o ID pelo caminho da requisição")
            @PathVariable Long id,
            @Parameter (description = "Usuario manda os dados a serem atualizados no corpo da requisição")
            @RequestBody UsuarioDTO usuarioAtualizado){
        try {
            usuarioService.atualizarUsuario(id, usuarioAtualizado);
            UsuarioDTO usuarioAtualizadoResponse = usuarioService.listarUsuariosPorId(id);
            return ResponseEntity.ok(usuarioAtualizadoResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario com id " + id + " não existe no nosso banco de dados.");
        }
    }

    //Deletar user (delete)
    @DeleteMapping("/deletar/{id}")
    @Operation (summary = "Deleta o usuario por ID", description = "Essa rota deleta um usuario pelo seu ID")
    public ResponseEntity<String> deletarUsuariosPorId(
            @Parameter (description = "Usuario manda o ID do usuario que deseja deletar")
            @PathVariable Long id){
        if (usuarioService.listarUsuariosPorId(id) != null){
            usuarioService.deletarUsuariosPorId(id);
            return ResponseEntity.ok("Usuario de ID: " + id + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario com id " + id + " não encontrado.");
        }
    }
}