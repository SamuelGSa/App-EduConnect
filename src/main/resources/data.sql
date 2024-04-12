CREATE TABLE IF NOT EXISTS usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    matricula VARCHAR(255) NOT NULL UNIQUE,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    data_nascimento DATE NOT NULL,
    telefone VARCHAR(255),
    endereco VARCHAR(255),
    tipo_usuario VARCHAR(255) NOT NULL,
    data_cadastro DATE NOT NULL,
    estado_conta VARCHAR(255) NOT NULL,
    CONSTRAINT chk_tipo_usuario CHECK (tipo_usuario IN ('PROFESSOR', 'ALUNO', 'ADMINISTRADOR')),
    CONSTRAINT chk_estado_conta CHECK (estado_conta IN ('ATIVADO', 'DESATIVADO'))
);

INSERT INTO usuario (matricula, nome, email, senha, data_nascimento, telefone, endereco, tipo_usuario, data_cadastro, estado_conta) VALUES
('MAT0001', 'João Silva', 'joao.silva@example.com', 'senhaSegura123', '1990-01-01', '999888777', 'Rua dos Bobos, 0', 'ADMINISTRADOR', '2023-04-01', 'ATIVADO'),
('MAT0002', 'Maria Oliveira', 'maria.oliveira@example.com', 'senhaForte456', '1991-02-02', '999777666', 'Avenida das Flores, 100', 'ADMINISTRADOR', '2023-04-02', 'ATIVADO'),
('MAT0003', 'Carlos Souza', 'carlos.souza@example.com', 'senhaDificil789', '1992-03-03', '999666555', 'Praça Central, 101', 'ADMINISTRADOR', '2023-04-03', 'ATIVADO'),
('MAT0004', 'Joaninha Leticia', 'joana.let@example.com', 'senhaDificil777', '1992-04-04', '999666111', 'Praça Almeiras, 123', 'ADMINISTRADOR', '2023-04-03', 'ATIVADO'),
('MAT0005', 'Pedro Martins', 'pedro.martins@example.com', 'senha456', '1994-05-05', '999444333', 'Alameda dos Anjos, 103', 'PROFESSOR', '2023-04-05', 'ATIVADO'),
('MAT0006', 'Fernanda Gomes', 'fernanda.gomes@example.com', 'senha789', '1995-06-06', '999333222', 'Travessa dos Sonhos, 104', 'PROFESSOR', '2023-04-06', 'ATIVADO'),
('MAT0007', 'Lucas Mendes', 'lucas.mendes@example.com', 'senha101112', '1996-07-07', '999222111', 'Vila Esperança, 105', 'ALUNO', '2023-04-07', 'ATIVADO'),
('MAT0008', 'Patricia Lima', 'patricia.lima@example.com', 'senha131415', '1997-08-08', '999111000', 'Beco da Fortuna, 106', 'ALUNO', '2023-04-08', 'ATIVADO'),
('MAT0009', 'Roberto Nunes', 'roberto.nunes@example.com', 'senha161718', '1998-09-09', '999000999', 'Caminho das Árvores, 107', 'ALUNO', '2023-04-09', 'ATIVADO'),
('MAT0010', 'Juliana Costa', 'juliana.costa@example.com', 'senha192021', '1999-10-10', '998999898', 'Avenida do Rio, 108', 'ALUNO', '2023-04-10', 'ATIVADO'),
('MAT0011', 'Marcos Ribeiro', 'marcos.ribeiro@example.com', 'senha222324', '2000-11-11', '998898797', 'Trilha do Sol, 109', 'ALUNO', '2023-04-11', 'ATIVADO'),
('MAT0012', 'Sofia Alves', 'sofia.alves@example.com', 'senha252627', '2001-12-12', '998797696', 'Passagem de Terra, 110', 'ALUNO', '2023-04-12', 'DESATIVADO'),
('MAT0014', 'Camila Rocha', 'camila.rocha@example.com', 'senha313233', '2003-02-14', '998595494', 'Ponte da Amizade, 112', 'ALUNO', '2023-04-14', 'DESATIVADO'),
('MAT0015', 'Ricardo Queiroz', 'ricardo.queiroz@example.com', 'senha343536', '2004-03-15', '998494393', 'Via Láctea, 113', 'ALUNO', '2023-04-15', 'ATIVADO');
