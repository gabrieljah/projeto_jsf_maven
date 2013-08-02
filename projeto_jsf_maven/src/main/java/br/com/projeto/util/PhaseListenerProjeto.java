package br.com.projeto.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;

/**
 *
 * @author gabriel
 */
public class PhaseListenerProjeto implements PhaseListener {

    //Antes da Fase
    @Override
    public void beforePhase(PhaseEvent fase) {
        System.out.println("Antes da Fase: " + getPhaseId());
        if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            FacesContextUtil.getRequestSession();
        }
    }

    //Depois da Fase
    @Override
    public void afterPhase(PhaseEvent fase) {
        System.out.println("Depois da Fase: " + getPhaseId());
        if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            
            Session session = FacesContextUtil.getRequestSession();
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            }finally{
                session.close();
            }
            
        }
        
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
}
