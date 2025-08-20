package com.java10x.CadastroDeUsuarios.Usuarios;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;


    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }


    // Listar todos os usuarios
    public List<UsuarioDTO> listarUsuarios(){
        List<UsuarioModel> usuario = usuarioRepository.findAll();
        return usuario.stream()
                .map(usuarioMapper::map)
                .collect(Collectors.toList());
    }

    //Listar usuario por ID
    public UsuarioDTO listarUsuariosPorId(Long id){
        Optional<UsuarioModel> usuarioPorId = usuarioRepository.findById(id);
        return usuarioPorId.map(usuarioMapper::map).orElse(null);
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
    public UsuarioDTO atualizarUsuario(Long id, UsuarioDTO usuarioDTO){
        Optional<UsuarioModel> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()){
            UsuarioModel usuarioAtual = usuarioMapper.map(usuarioDTO);
            usuarioAtual.setId(id);
            UsuarioModel usuarioSalvo = usuarioRepository.save(usuarioAtual);
            return  usuarioMapper.map(usuarioSalvo);
        }
        return null;
    }

}
