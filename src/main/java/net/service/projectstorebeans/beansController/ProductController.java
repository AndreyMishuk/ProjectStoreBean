
package net.service.projectstorebeans.beansController;

import net.service.projectstorebeans.beansCDI.ProductBean;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import net.service.projectstorebeans.entity.Product;
import net.service.projectstorebeans.session.ProductFacade;

@Named
@SessionScoped
public class ProductController implements Serializable {
    
    @EJB
    ProductFacade productFaced;
    
    @Inject
    ProductBean productBean;
    
    public List<Product> getAll() {
        return productFaced.findAll();
    }
    
    public int count() {
        return productFaced.count();
    }
    
    public String edit(Product product) {
        
        productBean.setId(product.getId());
        productBean.setTitle(product.getTitle());
        productBean.setPrice(product.getPrice());
        
        return "/pages/edit/product_edit";
        
    }
    
    public String save() {
        
        Product product = new Product();
        
        product.setId(productBean.getId());
        product.setTitle(productBean.getTitle());
        product.setPrice(productBean.getPrice());
        
        productFaced.edit(product);
        
        return "/pages/edit/product_edit";
    }
    
   
}
