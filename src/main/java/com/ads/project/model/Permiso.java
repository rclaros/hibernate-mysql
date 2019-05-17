/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.project.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "st_permiso")
public class Permiso extends Audit implements Serializable {

    @Column(name = "name")
    private String name;
    @Column(name = "acl")
    private Integer acl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAcl() {
        return acl;
    }

    public void setAcl(Integer acl) {
        this.acl = acl;
    }

}
