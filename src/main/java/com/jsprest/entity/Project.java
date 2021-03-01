package com.jsprest.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Project {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;


    private String name;

    @Lob
    private String description;

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;


    private boolean status;


    public Long getProjectId() {
        return projectId;
    }


    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public LocalDate getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }


    public LocalDate getUpdatedAt() {
        return updatedAt;
    }


    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }


    public boolean isStatus() {
        return status;
    }


    public void setStatus(boolean status) {
        this.status = status;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


}
