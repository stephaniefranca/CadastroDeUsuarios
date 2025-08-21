package com.java10x.CadastroDeUsuarios.Usuarios;

import com.java10x.CadastroDeUsuarios.Tarefas.TarefaModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
        import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/usuarios/ui")
public class UsuarioControllerUi {

    private final UsuarioService usuarioService;

    public UsuarioControllerUi(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "listarUsuarios";
    }

    @GetMapping("/deletar/{id}")
    public String deletarUsuarioPorId(@PathVariable Long id) {
        usuarioService.deletarUsuariosPorId(id);
        return "redirect:/usuarios/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String listarUsuariosPorId(@PathVariable Long id, Model model) {
        UsuarioDTO usuario = usuarioService.listarUsuariosPorId(id);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "detalhesUsuario";
        } else {
            model.addAttribute("mensagem", "Usuario não encontrado");
            return "listarUsuarios";
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarUsuario(Model model) {
        model.addAttribute("usuario", new UsuarioDTO());
        return "adicionarUsuario";
    }

    @PostMapping("/criar")
    public String criarUsuario(@ModelAttribute UsuarioDTO usuario, RedirectAttributes redirectAttributes) {
        usuarioService.criarUsuario(usuario);
        redirectAttributes.addFlashAttribute("mensagem", "Usuario cadastrado com sucesso!");
        return "redirect:/usuarios/ui/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        UsuarioDTO usuario = usuarioService.listarUsuariosPorId(id);
        model.addAttribute("usuario", usuario);
        return "editarUsuario";
    }

    @PostMapping("/atualizar")
    public String atualizarUsuario(@ModelAttribute UsuarioDTO usuario, RedirectAttributes redirectAttributes) {
        usuarioService.atualizarUsuario(usuario.getId(), usuario);
        redirectAttributes.addFlashAttribute("mensagem", "Usuário atualizado com sucesso!");
        return "redirect:/usuarios/ui/listar";
    }





}
