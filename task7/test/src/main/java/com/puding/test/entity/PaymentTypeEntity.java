package com.puding.test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PAYMENT_TYPE")
@Getter
@Setter
public class PaymentTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TYPE", nullable = false, unique = true)
    private String type;
}