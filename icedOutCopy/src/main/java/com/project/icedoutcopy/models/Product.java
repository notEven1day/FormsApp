package com.project.icedoutcopy.models;

import com.project.icedoutcopy.models.Enums.JewerlyType;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="products")
public class

Product extends BaseEntity {

    private String name;
    private String description;
    private BigDecimal price;
    private String material;
    private JewerlyType jewerlyType;
    private String size;
    private String imageUrl;

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(nullable = false)
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public JewerlyType getJewerlyType() {
        return jewerlyType;
    }

    public void setJewerlyType(JewerlyType jewerlyType) {
        this.jewerlyType = jewerlyType;
    }

    @Column(nullable = false)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Column(nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // Default constructor
    public Product() {}
}
