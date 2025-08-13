package com.java10x.CadastroDeUsuarios.Usuarios;

import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    // DTO → Model
    public UsuarioModel map(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) {
            return null;
        }

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setId(usuarioDTO.getId());
        usuarioModel.setNome(usuarioDTO.getNome());
        usuarioModel.setEmail(usuarioDTO.getEmail());
        usuarioModel.setIdade(usuarioDTO.getIdade());
        usuarioModel.setImgUrl(usuarioDTO.getImgUrl());
        usuarioModel.setRank(usuarioDTO.getRank());
        usuarioModel.setTarefas(usuarioDTO.getTarefas());

        return usuarioModel;
    }

    // Model → DTO
    public UsuarioDTO map(UsuarioModel usuarioModel) {
        if (usuarioModel == null) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuarioModel.getId());
        usuarioDTO.setNome(usuarioModel.getNome());
        usuarioDTO.setEmail(usuarioModel.getEmail());
        usuarioDTO.setIdade(usuarioModel.getIdade());
        usuarioDTO.setImgUrl(usuarioModel.getImgUrl());
        usuarioDTO.setRank(usuarioModel.getRank());
        usuarioDTO.setTarefas(usuarioModel.getTarefas());

        return usuarioDTO;
    }
}
