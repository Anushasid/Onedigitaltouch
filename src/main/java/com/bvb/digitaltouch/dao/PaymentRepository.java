package com.bvb.digitaltouch.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bvb.digitaltouch.modules.Payment;




public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
