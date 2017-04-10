package com.ifpb.login.modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Usuario {

    private String email;
    private String nome;
    private char sexo;
    private LocalDate nascimento;
    private String cargo;
    private String senha;

    public Usuario() {
    }

    public Usuario(String email, String nome, char sexo, LocalDate nascimento, String cargo, String senha) {
        this.email = email;
        this.nome = nome;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.cargo = cargo;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "email=" + email + ", nome=" + nome + ", sexo=" + sexo + ", nascimento=" + nascimento + ", cargo=" + cargo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + this.sexo;
        hash = 23 * hash + Objects.hashCode(this.nascimento);
        hash = 23 * hash + Objects.hashCode(this.cargo);
        hash = 23 * hash + Objects.hashCode(this.senha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.sexo != other.sexo) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        return true;
    }    
    
    public boolean autenticar(String email, String senha){
        return this.email.equals(email) 
                && this.senha.equals(senha);
    }
    
}
