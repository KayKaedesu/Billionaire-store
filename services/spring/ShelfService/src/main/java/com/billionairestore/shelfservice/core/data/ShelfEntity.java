package com.billionairestore.shelfservice.core.data;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "shelf")
@Data
public class ShelfEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -2143928070515464610L;

//    @Id
//    @Column(unique = true)
//    private String shelfId;
    @Id
    @Column(unique = true)
    private String productId;
    private int quantity;

}
