package com.jsprest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;


    private String name;


    public Long getRoleId() {
        return roleId;
    }


    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


}
