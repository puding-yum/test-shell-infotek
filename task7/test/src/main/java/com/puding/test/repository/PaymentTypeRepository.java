package com.puding.test.repository;

import com.puding.test.entity.PaymentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeRepository extends JpaRepository<PaymentTypeEntity, Long> {}
