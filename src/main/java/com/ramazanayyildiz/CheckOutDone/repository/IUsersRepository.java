package com.ramazanayyildiz.CheckOutDone.repository;

import com.ramazanayyildiz.CheckOutDone.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsersRepository extends JpaRepository<Users, Integer> {
}
