package com.ramazanayyildiz.CheckOutDone.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int productId;

    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private Users users;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "The product name cannot be blank!")
    private String productName;

    @Column(nullable = false,precision = 10,scale = 2)
    @NotNull(message = "The product price cannot be blank!")
    private BigDecimal productPrice;

    @NotNull(message = "If the product exists, please enter a value.")
    @Column(columnDefinition = "BIT DEFAULT 0",nullable = false)
    private Boolean productActive;

    @Column(name = "created_time", nullable = false)
    private LocalDateTime createdTime;

    @ManyToMany(mappedBy = "products")
    private List<CustomerVisit> customerVisits=new ArrayList<>();

    @PrePersist
    public void onPrePersist() {
        this.setCreatedTime(LocalDateTime.now());
    }
}
