package com.billionairestore.reportservice.core.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;

@Entity
@Table(name = "importlog")
@Data
public class ImportReportEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -2932063800221375469L;
    @Id
    @Column(unique = true)
    private String logId;
    private String userId;
    private String productId;
    private String name;
    private double quantity;
    private String category;
    private double buyPrice;
    private OffsetDateTime createdAt;
}
