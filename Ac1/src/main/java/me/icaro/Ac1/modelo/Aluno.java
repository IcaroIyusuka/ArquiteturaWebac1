package me.icaro.Ac1.modelo;

public class Aluno {

    private Long id;
    private String nome;
    private String sexo;
    private String email;
    private String telefone;

    public Aluno(Long id, String nome, String sexo, String email, String telefone){
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
