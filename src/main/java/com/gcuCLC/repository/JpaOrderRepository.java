package com.gcuCLC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcuCLC.entity.Orders;

public interface JpaOrderRepository extends JpaRepository<Orders,Integer>{

}
