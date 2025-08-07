package com.java10x.CadastroDeUsuarios.Usuarios;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Listar todos os usuarios
    public List<UsuarioModel> listarUsuarios(){
        return usuarioRepository.findAll();
    }
}
