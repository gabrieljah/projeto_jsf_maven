/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author gabriel
 */
@Entity
@Table(name="Estado")
public class Estado implements Serializable{
    
      private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdEstado", nullable = false)
    private Integer idEstado;
    @Column(name="Nome", length = 80, nullable=false)
    private String nome;
    
    @OneToMany
    @ForeignKey(name="EstadoEndereco")
    private List<Endereco> enderecos;

    public Estado() {
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estado other = (Estado) obj;
        if (this.idEstado != other.idEstado && (this.idEstado == null || !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.idEstado != null ? this.idEstado.hashCode() : 0);
        return hash;
    }
    
    
    
    
}