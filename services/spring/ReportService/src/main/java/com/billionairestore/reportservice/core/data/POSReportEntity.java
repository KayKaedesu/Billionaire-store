package com.billionairestore.reportservice.core.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity
@Table(name = "poslog")
@Data
public class POSReportEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1215380801452571168L;
    @Id
    @Column(unique = true)
    private String logId;
    private String userId;
    private String productId;
    private String name;
    private int quantity;
    private double sellPrice;
    private OffsetDateTime createdAt;
}
