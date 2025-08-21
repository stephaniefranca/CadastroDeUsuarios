package com.java10x.CadastroDeUsuarios.Usuarios;

import com.java10x.CadastroDeUsuarios.Tarefas.TarefaModel;
import com.java10x.CadastroDeUsuarios.Tarefas.TarefaRepository; // Importe o TarefaRepository
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final TarefaRepository tarefaRepository; // Adicione esta dependência

    public UsuarioService(UsuarioRepository usuarioRepository,
                          UsuarioMapper usuarioMapper,
                          TarefaRepository tarefaRepository) { // Injete via construtor
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.tarefaRepository = tarefaRepository; // Inicialize a dependência
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
    public void atualizarUsuario(Long id, UsuarioDTO usuarioDTO) {
        UsuarioModel usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Preserva os dados existentes e atualiza apenas os campos do formulário
        usuarioExistente.setNome(usuarioDTO.getNome());
        usuarioExistente.setEmail(usuarioDTO.getEmail());
        usuarioExistente.setIdade(usuarioDTO.getIdade());

        // Mantém imgUrl e rank se estiverem sendo enviados (campos ocultos)
        if (usuarioDTO.getImgUrl() != null && !usuarioDTO.getImgUrl().isEmpty()) {
            usuarioExistente.setImgUrl(usuarioDTO.getImgUrl());
        }

        if (usuarioDTO.getRank() != null && !usuarioDTO.getRank().isEmpty()) {
            usuarioExistente.setRank(usuarioDTO.getRank());
        }

        // Atualiza a tarefa se foi selecionada uma nova
        if (usuarioDTO.getTarefas() != null && usuarioDTO.getTarefas().getId() != null) {
            TarefaModel tarefa = tarefaRepository.findById(usuarioDTO.getTarefas().getId())
                    .orElse(null);
            usuarioExistente.setTarefas(tarefa);
        } else {
            // Se não foi selecionada tarefa, remove a associação
            usuarioExistente.setTarefas(null);
        }

        usuarioRepository.save(usuarioExistente);
    }
}