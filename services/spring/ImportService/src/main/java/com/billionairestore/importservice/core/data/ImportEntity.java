package com.billionairestore.importservice.core.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
@Entity
@Table(name = "imports")
@Data
public class ImportEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 2948319659879930009L;

    @Id
    @Column(unique = true)
    private String importId;

    @Column(unique = true)
    private String productId;

    @Column(unique = true)
    private String name;
    private String category;
    private Double buyPrice;

}
