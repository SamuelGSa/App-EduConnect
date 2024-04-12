package com.br.educonnect.persistence.mapper;

import com.br.educonnect.dto.usuario.request.UsuarioDTO;
import com.br.educonnect.dto.usuario.response.UsuarioResponseDTO;
import com.br.educonnect.persistence.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public Usuario mapDTOToModel(UsuarioDTO usuarioDTO) {
        return modelMapper.map(usuarioDTO, Usuario.class);
    }

    // Método para mapear de Usuario para UsuarioResponseDTO
    public UsuarioResponseDTO mapModelToDTO(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioResponseDTO.class);
    }


}
