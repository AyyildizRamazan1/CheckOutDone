package com.ramazanayyildiz.CheckOutDone.entity;

import com.ramazanayyildiz.CheckOutDone.entity.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int userId;

    @NotBlank(message = "The username cannot be blank!")
    @Column(nullable = false, unique = true, length = 50)
    private String userName;

    @NotBlank(message = "The password cannot be blank!")
    @Column(nullable = false, length = 50)
    private String password;

    @Column(nullable = false)
    @NotNull(message = "The Role cannot be blank!")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "created_time", nullable = false)
    private LocalDateTime createdTime;

    @OneToMany(mappedBy = "users")
    private List<Tables> tables = new ArrayList<>();

    @OneToMany(mappedBy = "users")
    private List<Products> products = new ArrayList<>();

    @OneToMany(mappedBy = "users")
    private List<CustomerVisit> customerVisits = new ArrayList<>();

    @PrePersist
    public void onPrePersist() {
        this.setCreatedTime(LocalDateTime.now());
    }


}
