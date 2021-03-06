/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.suport;

/**
 *
 * @author gabriel
 */
import br.com.projeto.model.dao.HibernateDAO;
import br.com.projeto.model.dao.InterfaceDAO;
import br.com.projeto.model.entities.TipoEndereco;
import br.com.projeto.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;

@ManagedBean(name = "bbTipoEndereco")
@RequestScoped
public class BbTipoEndereco implements Serializable {

    private static final long serialVersionUID = 1L;

    public List<TipoEndereco> getTipoEnderecos() {
        Session session = FacesContextUtil.getRequestSession();
        InterfaceDAO<TipoEndereco> tipoEnderecoDAO = new HibernateDAO<TipoEndereco>(TipoEndereco.class, session);
        return tipoEnderecoDAO.getEntities();
    }
}
