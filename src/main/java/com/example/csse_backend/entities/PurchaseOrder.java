package com.example.csse_backend.entities;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String date;

    private String siteName;

    private String status;

    private String supplierName;

    private String deliveryAddress;

   @OneToMany(mappedBy = "purchaseOrder", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
   private List<Item> items = new ArrayList<>();

}
