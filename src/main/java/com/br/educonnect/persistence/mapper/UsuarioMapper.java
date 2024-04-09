package com.br.educonnect.persistence.mapper;

import com.br.educonnect.dto.usuario.UsuarioDTO;
import com.br.educonnect.persistence.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public Usuario mapDTOToModel(UsuarioDTO usuarioDTO) {
        return modelMapper.map(usuarioDTO, Usuario.class);
    }


}
