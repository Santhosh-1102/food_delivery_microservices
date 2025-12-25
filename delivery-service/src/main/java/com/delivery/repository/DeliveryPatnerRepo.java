package com.delivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.model.DeliveryPatner;

@Repository
public interface DeliveryPatnerRepo extends JpaRepository<DeliveryPatner, Integer>{

	Optional<DeliveryPatner> findFirstByAvailableTrue();
}
