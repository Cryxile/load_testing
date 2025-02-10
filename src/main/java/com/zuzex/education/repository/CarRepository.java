package com.zuzex.education.repository;

import com.zuzex.education.model.db.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    @Modifying
    @Query(value = "DELETE FROM cars WHERE owner_id = :ownerId", nativeQuery = true)
    void deleteByOwner(UUID ownerId);

    List<Car> getAllByOwner(UUID ownerId);
}
