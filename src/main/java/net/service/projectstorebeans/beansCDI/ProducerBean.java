
package net.service.projectstorebeans.beansCDI;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ProducerBean implements Serializable {
    
    private Integer id;
    private String title;
    private String description;
    private byte[] logotip;

    public ProducerBean() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getLogotip() {
        return logotip;
    }

    public void setLogotip(byte[] logotip) {
        this.logotip = logotip;
    }
    
    
    
}
