
package net.service.projectstorebeans.beansController;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.inject.Named;
import net.service.projectstorebeans.beansCDI.Message;

@Named
@Singleton
public class AdminController {
    
    @Inject
    Message message;
    
    @Lock(LockType.WRITE)
    public String getMessage() {
        message.setMessage(message.getMessage());
        return "/pages/admin_page";
    }
    
    public String getReturn() {
        return "/pages/store";
    }
    
}
