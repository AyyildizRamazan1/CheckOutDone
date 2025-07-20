package com.ramazanayyildiz.CheckOutDone.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Tables")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int tableId;

    @NotBlank(message = "The table number cannot be blank!")
    @Column(nullable = false, unique = true, length = 5)
    private String tableNumber;

    @Column(columnDefinition = "BIT DEFAULT 0", nullable = false)
    private boolean tableIsOpen;

    @Column(name = "created_time", nullable = false)
    private LocalDateTime createdTime;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private Users users;

    @OneToMany(mappedBy = "tables")
    private List<CustomerVisit> customerVisits = new ArrayList<>();

    @PrePersist
    public void onPrePersist() {
        this.setCreatedTime(LocalDateTime.now());
    }
}
