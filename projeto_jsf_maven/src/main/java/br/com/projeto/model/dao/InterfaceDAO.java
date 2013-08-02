/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author gabriel
 */
public interface InterfaceDAO<T> {
    
    void save(T entity);
    void update(T entity);
    void remove (T entity);
    void merge (T entity);
    T getEntity(Serializable id);
    T getEntityByDetachedCriteria(DetachedCriteria criteria);    
    List<T> getEntities();
    List<T> getListByDetachedCriteria(DetachedCriteria criteria);
    
    
}
