
package net.service.projectstorebeans.beansController;

import net.service.projectstorebeans.beansCDI.ProducerBean;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import net.service.projectstorebeans.entity.Producer;
import net.service.projectstorebeans.session.ProducerFacade;

@Named
@SessionScoped
public class ProducerConrtroller implements Serializable {
    
    @EJB
    ProducerFacade producerFacade;
    
    @Inject
    ProducerBean producerBean;
    
    public List<Producer> getAll() {
        return producerFacade.findAll();
    }
    
    public int count() {
        return producerFacade.count();
    }
    
    public String add() {
        
        Producer producer = new Producer();
        
        producer.setTitle(producerBean.getTitle());
        producer.setDescription(producerBean.getDescription());
        producer.setQuantity(producerBean.getQuantity());
        producer.setLogotip(producerBean.getLogotip());
        
        producerFacade.create(producer);
        
        return "/pages/admin_page";
        
    }
    
    public String edit() {
        
        
        return "";
    }
    
}
