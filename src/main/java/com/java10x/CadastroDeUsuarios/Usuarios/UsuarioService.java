package com.java10x.CadastroDeUsuarios.Usuarios;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    //Listar usuario por ID
    public UsuarioModel listarUsuariosPorId(Long id){
        Optional<UsuarioModel> usuarioPorId = usuarioRepository.findById(id);
        return usuarioPorId.orElse(null);
    }

    //Criar usuario
    public UsuarioModel criarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }
}
