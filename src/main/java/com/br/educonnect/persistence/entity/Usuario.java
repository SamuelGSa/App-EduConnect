    package com.br.educonnect.persistence.entity;

    import com.br.educonnect.constants.EstadoContaEnum;
    import com.br.educonnect.constants.TipoUsuarioEnum;
    import jakarta.persistence.*;
    import lombok.*;

    import java.time.LocalDate;
    import java.util.Date;
    import java.util.UUID;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "usuario")
    public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "matricula", unique = true, nullable = false)
        private String matricula;

        @Column(name = "nome", nullable = false)
        private String nome;

        @Column(name = "email", unique = true, nullable = false)
        private String email;

        @Column(name = "senha", nullable = false)
        private String senha;

        @Column(name = "data_nascimento", nullable = false)
        private LocalDate dataNascimento;

        @Column(name = "telefone")
        private String telefone;

        @Column(name = "endereco")
        private String endereco;

        @Enumerated(EnumType.STRING)
        @Column(name = "tipo_usuario", nullable = false)
        private TipoUsuarioEnum tipoUsuario;


        @Column(name = "data_cadastro", nullable = false)
        private LocalDate dataCadastro;

        @Enumerated(EnumType.STRING)
        @Column(name = "estado_conta", nullable = false)
        private EstadoContaEnum estadoConta;


    }
