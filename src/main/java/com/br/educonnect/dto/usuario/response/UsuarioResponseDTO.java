package com.br.educonnect.dto.usuario.response;

import com.br.educonnect.constants.EstadoContaEnum;
import com.br.educonnect.constants.TipoUsuarioEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDTO {

    @JsonProperty("matricula")
    private String matricula;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("tipoUsuario")
    private TipoUsuarioEnum tipoUsuario;

    @JsonProperty("estadoConta")
    private EstadoContaEnum estadoConta;

    @JsonProperty("dataNascimento")
    private String dataNascimento;

    @JsonProperty("dataCadastro")
    private String dataCadastro;
}