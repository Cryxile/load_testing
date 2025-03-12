package com.zuzex.education.repository.hibernate;

import com.zuzex.education.model.db.Car;
import com.zuzex.education.repository.CarRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Profile("hibernate")
public interface CarHibernateRepository extends JpaRepository<Car, UUID>, CarRepository {
    List<Car> findAllByOwner(UUID ownerId);

    @Override
    Optional<Car> findById(UUID uuid);

    @Override
    Car save(Car car);

    @Override
    void deleteById(UUID uuid);

    @Modifying
    @Query(value = "DELETE FROM cars WHERE owner_id = :ownerId", nativeQuery = true)
    void deleteByOwner(UUID ownerId);
}
