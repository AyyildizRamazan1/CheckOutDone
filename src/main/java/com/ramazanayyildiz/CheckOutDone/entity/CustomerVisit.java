package com.ramazanayyildiz.CheckOutDone.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CustomerVisit")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int customerVisitId;

    @Column(nullable = false)
    private short productQuantity;

    @Column(nullable = false, columnDefinition = "BIT DEFAULT 0")
    private boolean paid;

    @Column(nullable = false)
    private LocalDate sitTime;

    @Column(nullable = false)
    private LocalDate leaveTime;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "tableId", nullable = false)
    private Tables tables;

    @ManyToMany
    @JoinTable(
            name = "customerVisit_products",
            joinColumns = @JoinColumn(name = "customerVisitId"),
            inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private List<Products> products = new ArrayList<>();//null pointer hatası yaşamamak için ArrayList

}
