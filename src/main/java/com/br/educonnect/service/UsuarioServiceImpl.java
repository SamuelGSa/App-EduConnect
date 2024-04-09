package com.br.educonnect.service;

import com.br.educonnect.dto.usuario.UsuarioDTO;
import com.br.educonnect.persistence.entity.Usuario;
import com.br.educonnect.persistence.mapper.UsuarioMapper;
import com.br.educonnect.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UserRepository userRepository;

    private final UsuarioMapper usuarioMapper;


    public List<Usuario> buscaTodosUsuarios() {
        log.info("Buscando todos os usuários");

        List<Usuario> usuariosList = new ArrayList<>();

        usuariosList = userRepository.findAll();

        log.info(usuariosList.size() + " Usuarios Encontrados");


        return usuariosList;

    }

    public Usuario salvaUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.mapDTOToModel(usuarioDTO);

        log.info("Salvando usuario");
        userRepository.save(usuario);

        return usuario;

    }

    public Optional<Usuario> buscaUsuarioPorId(Long id) {

        log.info("Buscando usuario por id");
        return userRepository.findById(id);

    }

    public void deletaUsuarioPorID(Long id) {

        userRepository.deleteById(id);

    }

    public  Usuario atualizaUsuarioPorId(Long id, UsuarioDTO novoUsuario) {

        return userRepository.findById(id)
                .map(usuario -> {
                    usuario.setNome(novoUsuario.getNome());
                    usuario.setMatricula(novoUsuario.getMatricula());
                    Usuario usuarioAtualizado = userRepository.save(usuario);
                    return usuarioAtualizado;
                }).orElseThrow(RuntimeException::new);
//
    }


}
