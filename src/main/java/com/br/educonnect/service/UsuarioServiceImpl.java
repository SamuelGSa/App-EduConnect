package com.br.educonnect.service;

import com.br.educonnect.dto.usuario.request.UsuarioDTO;
import com.br.educonnect.dto.usuario.response.UsuarioResponseDTO;
import com.br.educonnect.persistence.entity.Usuario;
import com.br.educonnect.persistence.mapper.UsuarioMapper;
import com.br.educonnect.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static com.br.educonnect.utils.DataUtils.formataData;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UserRepository userRepository;

    private final UsuarioMapper usuarioMapper;

    public List<UsuarioResponseDTO> buscaTodosUsuarios() {
        log.info("Buscando todos os usuários");

        List<Usuario> usuariosList = userRepository.findAll();

        log.info(usuariosList.size() + " Usuarios Encontrados");

        // Usando o UsuarioMapper para converter a lista
        var listaUsuarios = usuariosList.stream()
                .map(usuarioMapper::mapModelToDTO)
                .collect(Collectors.toList());

        for (UsuarioResponseDTO usuario : listaUsuarios) {
            usuario.setDataCadastro(String.valueOf(formataData(LocalDate.parse(usuario.getDataCadastro()))));
            usuario.setDataNascimento(String.valueOf(formataData(LocalDate.parse(usuario.getDataNascimento()))));
        }
        return listaUsuarios;
    }

    public UsuarioResponseDTO salvaUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.mapDTOToModel(usuarioDTO);

        log.info("Salvando usuario");
        userRepository.save(usuario);
         var usuarioResponse = usuarioMapper.mapModelToDTO(usuario);
        usuarioResponse.setDataCadastro(formataData(usuario.getDataCadastro()));
        usuarioResponse.setDataNascimento(formataData(usuario.getDataNascimento()));

        return usuarioResponse;
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
