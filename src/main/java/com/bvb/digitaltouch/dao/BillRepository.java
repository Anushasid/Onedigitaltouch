package com.bvb.digitaltouch.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bvb.digitaltouch.Enum.ServiceType;
import com.bvb.digitaltouch.modules.Bill;

public interface BillRepository extends JpaRepository<Bill,Integer> {

   //List<Bill> findByUserId(Integer id);
   Optional<Bill> findByUserIdAndServiceType(Integer userId, ServiceType serviceType);
}
