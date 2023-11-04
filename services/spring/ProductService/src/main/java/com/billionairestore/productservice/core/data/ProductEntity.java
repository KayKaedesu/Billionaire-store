package com.billionairestore.productservice.core.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "products")
@Data
public class ProductEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -5572534788390721939L;

    @Id
    @Column(unique = true)
    private String productId;

    @Column(unique = true)
    private String name;

    private String imageUrl;
    private String category;
    private Double buyPrice;
    private Double sellPrice;
}
