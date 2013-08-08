/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.suport;

import br.com.projeto.model.dao.HibernateDAO;
import br.com.projeto.model.dao.InterfaceDAO;
import br.com.projeto.model.entities.Cidade;
import br.com.projeto.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author gabriel
 */
@ManagedBean(name="bbCidade")
@RequestScoped
public class BbCidade  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private List<Cidade> cidades;

    public List<Cidade> getCidades() {
        InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());
        return cidadeDAO.getEntities();
    }
}
