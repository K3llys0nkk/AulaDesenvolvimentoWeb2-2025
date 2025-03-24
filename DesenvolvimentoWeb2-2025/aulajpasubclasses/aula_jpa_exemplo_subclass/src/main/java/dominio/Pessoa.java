package dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long idPessoa;
    private String nome;
    private String cpf;

    public Pessoa(){
        this("", "");
    }

    public Pessoa(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public long getIdPessoa(){
        return idPessoa;
    }
    public void setIdPessoa(long idPessoa){
        this.idPessoa = idPessoa;
    }

    public String getNome(){
        return this.nome;
    }
    public void getNome(String nome){
        this.nome = nome;
    }

    public String getCpf(){
        return this.cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    @Oveerride
    public String toString(){
        return "Pessoa [idPessoa=" + idPessoa + ", nome=" + nome + ", CPF=" + cpf +"]";
    }
}
