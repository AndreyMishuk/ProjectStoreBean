/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.service.projectstorebeans.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andrey
 */
@Entity
@Table(name = "producer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producer.findAll", query = "SELECT p FROM Producer p")
    , @NamedQuery(name = "Producer.findById", query = "SELECT p FROM Producer p WHERE p.id = :id")
    , @NamedQuery(name = "Producer.findByTitle", query = "SELECT p FROM Producer p WHERE p.title = :title")
    , @NamedQuery(name = "Producer.findByDescription", query = "SELECT p FROM Producer p WHERE p.description = :description")
    , @NamedQuery(name = "Producer.findByQuantity", query = "SELECT p FROM Producer p WHERE p.quantity = :quantity")})
public class Producer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 100)
    @Column(name = "title")
    private String title;
    
    @Size(max = 150)
    @Column(name = "description")
    private String description;
    
    @Column(name = "quantity")
    private Integer quantity;
    
    @Lob
    @Column(name = "logotip")
    private byte[] logotip;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producerId")
    private Collection<Product> productCollection;

    public Producer() {
    }

    public Producer(Integer id) {
        this.id = id;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public byte[] getLogotip() {
        return logotip;
    }

    public void setLogotip(byte[] logotip) {
        this.logotip = logotip;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producer)) {
            return false;
        }
        Producer other = (Producer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.service.projectstorebeans.entity.Producer[ id=" + id + " ]";
    }
    
}
