package com.br.educonnect.controller;

import com.br.educonnect.dto.usuario.request.UsuarioDTO;
import com.br.educonnect.dto.usuario.response.UsuarioResponseDTO;
import com.br.educonnect.persistence.entity.Usuario;
import com.br.educonnect.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Validated
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;


    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> buscaTodosUsuarios() {
        var listaUsuarios = usuarioService.buscaTodosUsuarios();
        return new ResponseEntity<>(listaUsuarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> salvaUsuario( @RequestBody UsuarioDTO usuarioDTO) {

        var usuarioSalvo = usuarioService.salvaUsuario(usuarioDTO);
        return new ResponseEntity<>(usuarioSalvo,HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> getUserById(@PathVariable Long id) {

        var usuarioSolicitado = usuarioService.buscaUsuarioPorId(id);
        return new ResponseEntity<>(usuarioSolicitado,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> deleteUserById(@PathVariable Long id) {

        try {
            usuarioService.deletaUsuarioPorID(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException nsee){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUserById(@PathVariable Long id, @RequestBody UsuarioDTO novoUsuario) {

        try {
            usuarioService.atualizaUsuarioPorId(id,novoUsuario) ;
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException nsee){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

}
