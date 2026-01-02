package com.vinilab.ecommerce_api.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client implements Serializable {
    @Serial
    private static final Long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private Boolean isActive;

    @OneToMany(mappedBy = "order")
    List<Order> orders = new ArrayList<Order>();
}
