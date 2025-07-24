package com.ramazanayyildiz.CheckOutDone.repository;

import com.ramazanayyildiz.CheckOutDone.entity.CustomerVisit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerVisitRepository extends JpaRepository<CustomerVisit, Integer> {
}
