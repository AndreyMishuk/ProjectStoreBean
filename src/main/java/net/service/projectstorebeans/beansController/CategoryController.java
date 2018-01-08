
package net.service.projectstorebeans.beansController;

import net.service.projectstorebeans.beansCDI.CategoryBean;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import net.service.projectstorebeans.entity.Category;
import net.service.projectstorebeans.session.CategoryFacade;

@Named
@SessionScoped
public class CategoryController implements Serializable {
    
    @EJB
    CategoryFacade categoryFacade;
    
    @Inject
    CategoryBean categoryBean;
    
    public List<Category> getAll() {
        return categoryFacade.findAll();
    }
    
    public int caunt() {
        return categoryFacade.count();
    }
    
    
    
}
