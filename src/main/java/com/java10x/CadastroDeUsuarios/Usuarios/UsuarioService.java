package com.java10x.CadastroDeUsuarios.Usuarios;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioMapper usuarioMapper;


    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
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
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO){
        UsuarioModel usuario = usuarioMapper.map(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.map(usuario);
    }

    //Deletar usuario por ID - tem que ver metodo VOID
    public void deletarUsuariosPorId(Long id){
        usuarioRepository.deleteById(id);
    }

    // Atualizar usuario
    public UsuarioModel atualizarUsuario(Long id, UsuarioModel usuarioAtualizado){
        if(usuarioRepository.existsById(id)){
            usuarioAtualizado.setId(id);
            return usuarioRepository.save(usuarioAtualizado);
        }
        return null;
    }

}
