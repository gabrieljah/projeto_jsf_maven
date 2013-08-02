package br.com.projeto.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author gabriel
 */

@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdPessoa", nullable=false)
    private Integer idPessoa;
    @Column(name="Nome", nullable=false, length=80)
    private String nome;
    @Column(name="Email", nullable=false, length=80)
    private String email;
    @Column(name="Telefone", nullable=false, length=14)
    private String telefone;
    @Column(name="CPF", nullable=false, length=80)
    private String cpf;
    @Column(name="Data_de_Nascimento", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeNascimento;
    @Column(name="Data_de_Cadastro", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeCadastro;
    
    @ManyToOne(optional = false)
    @ForeignKey(name = "PessoaSexo")
    private Pessoa pessoa;

    public Pessoa() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.idPessoa != other.idPessoa && (this.idPessoa == null || !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.idPessoa != null ? this.idPessoa.hashCode() : 0);
        return hash;
    }
        
}
