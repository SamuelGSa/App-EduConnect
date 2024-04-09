package com.br.educonnect.service;

import com.br.educonnect.dto.usuario.UsuarioDTO;
import com.br.educonnect.persistence.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> buscaTodosUsuarios();

   Usuario salvaUsuario(UsuarioDTO usuarioDTO);

    Optional<Usuario> buscaUsuarioPorId(Long id);

    void deletaUsuarioPorID(Long id);

    Usuario atualizaUsuarioPorId(Long id, UsuarioDTO novoUsuario);
}
