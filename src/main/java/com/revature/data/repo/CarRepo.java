package com.revature.data.repo;

import com.revature.data.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepo extends JpaRepository<Car, UUID> {
}
