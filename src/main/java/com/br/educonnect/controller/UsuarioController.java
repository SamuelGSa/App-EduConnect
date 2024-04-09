package com.br.educonnect.controller;

import com.br.educonnect.dto.usuario.UsuarioDTO;
import com.br.educonnect.persistence.entity.Usuario;
import com.br.educonnect.persistence.mapper.UsuarioMapper;
import com.br.educonnect.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Validated
@Slf4j
public class UsuarioController {

    @Autowired
    UserRepository userRepository;

    private final UsuarioMapper usuarioMapper;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers() {

        List<Usuario> user = new ArrayList<>();

        user = userRepository.findAll();

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> saveUser( @RequestBody UsuarioDTO usuarioDTO) {

        Usuario usuario = usuarioMapper.mapDTOToModel(usuarioDTO);

        userRepository.save(usuario);

        return new ResponseEntity<>(usuario,HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> getUserById(@PathVariable Integer id) {

        var usuarioSolicitado  = userRepository.findById(id);

        return new ResponseEntity<>(usuarioSolicitado,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> deleteUserById(@PathVariable Integer id) {
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (NoSuchElementException nsee){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUserById(@PathVariable Integer id, @RequestBody UsuarioDTO novoUsuario) {

        return userRepository.findById(id)
                .map(usuario -> {
                    usuario.setNome(novoUsuario.getNome());
                    usuario.setMatricula(novoUsuario.getMatricula());
                    Usuario usuarioAtualizado = userRepository.save(usuario);

                    return ResponseEntity.ok().body(usuarioAtualizado);
                }).orElse(ResponseEntity.notFound().build());
    }


}
