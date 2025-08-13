package com.java10x.CadastroDeUsuarios.Usuarios;

import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioModel map(UsuarioDTO usuarioDTO){
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

    public UsuarioDTO map(UsuarioModel usuarioModel){
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId(usuarioDTO.getId());
        usuarioDTO.setNome(usuarioDTO.getNome());
        usuarioDTO.setEmail(usuarioDTO.getEmail());
        usuarioDTO.setIdade(usuarioDTO.getIdade());
        usuarioDTO.setImgUrl(usuarioDTO.getImgUrl());
        usuarioDTO.setRank(usuarioDTO.getRank());
        usuarioDTO.setTarefas(usuarioDTO.getTarefas());

        return usuarioDTO;

    }
}
