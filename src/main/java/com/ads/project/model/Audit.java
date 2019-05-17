/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.project.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

@MappedSuperclass
public abstract class Audit implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "created_by")
    protected String createdby;
    @Column(name = "created")
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date created;
    @Column(name = "modified")
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date modified;
    @Column(name = "modified_by")
    protected String modifedby;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getModifedby() {
        return modifedby;
    }

    public void setModifedby(String modifedby) {
        this.modifedby = modifedby;
    }

}
