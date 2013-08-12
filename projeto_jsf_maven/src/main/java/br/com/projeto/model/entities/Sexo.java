
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
@Table(name="SEXO")
public class Sexo implements Serializable{
    
    private static final long serialVersionUID = 1L;
         
    
    @Id
    @GeneratedValue
    @Column(name="IdSexo")
    private Integer idSexo;
    @Column(name="DescricaoSexo", nullable=false, unique=true, length=9)
    private String descricaoSexo;
    
    @OneToMany(mappedBy = "sexo", fetch = FetchType.LAZY)
    @ForeignKey(name = "PessoaSexo")
    private List<Pessoa> pessoas;

    public Sexo() {
    }

    public String getDescricao() {
        return descricaoSexo;
    }

    public void setDescricao(String descricao) {
        this.descricaoSexo = descricao;
    }

    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sexo other = (Sexo) obj;
        if (this.idSexo != other.idSexo && (this.idSexo == null || !this.idSexo.equals(other.idSexo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + (this.idSexo != null ? this.idSexo.hashCode() : 0);
        return hash;
    }
    
    
    
    
}
