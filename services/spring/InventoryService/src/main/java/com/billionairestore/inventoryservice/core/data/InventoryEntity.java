package com.billionairestore.inventoryservice.core.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "inventory")
@Data
public class InventoryEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 8945579629032859722L;

    @Id
    @Column(unique = true)
    private String productId;
    private int quantity;

}
