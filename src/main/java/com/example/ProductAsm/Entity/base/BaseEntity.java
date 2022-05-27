package com.example.ProductAsm.Entity.base;

import com.example.ProductAsm.Entity.StatusEnum.ProductEN;
import com.example.ProductAsm.Entity.validation.ProductValidation;

import java.time.LocalDateTime;

public abstract class BaseEntity {
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    public LocalDateTime deletedAt;
    public int createdBy;
    public int updatedBy;
    public int deletedBy;
    public ProductEN status;

    public BaseEntity() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.deletedAt = LocalDateTime.now();
        this.createdBy = 1;
        this.updatedBy = 1;
        this.deletedBy = 1;
        this.status = ProductEN.ACTIVE;
    }

    public BaseEntity(LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, int createdBy, int updatedBy, int deletedBy, ProductEN productEN) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.deletedBy = deletedBy;
        this.status = productEN;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public int getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(int deletedBy) {
        this.deletedBy = deletedBy;
    }

    public ProductEN getProductEN() {
        return status;
    }

    public void setProductEN(ProductEN productEN) {
        this.status = productEN;
    }

    public abstract Object getDescription();
}
