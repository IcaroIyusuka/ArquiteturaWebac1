-- Database: alunos

-- DROP DATABASE IF EXISTS alunos;

CREATE DATABASE alunos
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- Criação da tabela 'aluno'
CREATE TABLE IF NOT EXISTS public.aluno
(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    sexo VARCHAR(10),
    email VARCHAR(255),
    telefone VARCHAR(20)
);

-- Altera o dono da tabela 'task'
ALTER TABLE IF EXISTS public.aluno
    OWNER TO icaro;

