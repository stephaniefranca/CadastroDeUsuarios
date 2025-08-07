package com.java10x.CadastroDeUsuarios.Usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  UsuarioRepository extends JpaRepository <UsuarioModel, Long> {
}
