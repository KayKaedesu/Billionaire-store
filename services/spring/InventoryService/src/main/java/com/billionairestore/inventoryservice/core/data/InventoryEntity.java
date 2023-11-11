package com.billionairestore.inventoryservice.core.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "inventory")
@Data
public class InventoryEntity implements Serializable {
    @Id
    @Column(unique = true)
    private String productId;
    private int quantity;
}
