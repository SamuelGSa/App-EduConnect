package com.br.educonnect.dto.usuario.request;

import com.br.educonnect.constants.EstadoContaEnum;
import com.br.educonnect.constants.TipoUsuarioEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
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

    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("dataNascimento")
    private LocalDate dataNascimento;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("endereco")
    private String endereco;

    @JsonProperty("tipoUsuario")
    private TipoUsuarioEnum tipoUsuario;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("dataCadastro")
    private LocalDate dataCadastro = LocalDate.now();

    @JsonProperty("estadoConta")
    private EstadoContaEnum estadoConta;

}
