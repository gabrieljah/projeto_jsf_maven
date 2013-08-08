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
import br.com.projeto.model.entities.Estado;
import br.com.projeto.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="bbEstado")
@RequestScoped
public class BbEstado  implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public List<Estado> getEstados() {
        InterfaceDAO<Estado> estadoDAO = new HibernateDAO<Estado>(Estado.class, FacesContextUtil.getRequestSession());
        return estadoDAO.getEntities();
    }	
}
