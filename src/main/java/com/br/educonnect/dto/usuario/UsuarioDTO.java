package com.br.educonnect.dto.usuario;

import com.br.educonnect.constants.EstadoContaEnum;
import com.br.educonnect.constants.TipoUsuarioEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    @JsonProperty("matricula")
    private String matricula;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("email")
    private String email;

    @JsonProperty("senha")
    private String senha;

    @JsonProperty("dataNascimento")
    private Date dataNascimento;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("endereco")
    private String endereco;

    @JsonProperty("tipoUsuario")
    private TipoUsuarioEnum tipoUsuario;

    @JsonProperty("dataCadastro")
    private Date dataCadastro;

    @JsonProperty("estadoConta")
    private EstadoContaEnum estadoConta;

}
