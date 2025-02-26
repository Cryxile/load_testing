package com.zuzex.education.repository.jooq;

import com.zuzex.education.model.db.Car;
import com.zuzex.education.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.generated.tables.Cars;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Profile("jooq")
@Repository
@RequiredArgsConstructor
public class CarJooqRepository implements CarRepository {
    private final DSLContext dslContext;

    @Override
    public List<Car> findAll() {
        return dslContext.selectFrom(Cars.CARS)
                .fetchInto(Car.class);
    }

    @Override
    public List<Car> findAllByOwner(UUID id) {
        return dslContext.selectFrom(Cars.CARS)
                .where(Cars.CARS.OWNER_ID.eq(id))
                .fetchInto(Car.class);
    }

    @Override
    public Optional<Car> findById(UUID ownerId) {
        return dslContext.selectFrom(Cars.CARS)
                .where(Cars.CARS.ID.eq(ownerId))
                .fetchOptionalInto(Car.class);
    }

    @Override
    public Car save(Car car) {
        return dslContext.insertInto(Cars.CARS)
                .set(dslContext.newRecord(Cars.CARS, car))
                .onConflict(Cars.CARS.ID)
                .doUpdate()
                .set(dslContext.newRecord(Cars.CARS, car))
                .returning()
                .fetchOneInto(Car.class);
    }

    @Override
    public void deleteById(UUID id) {
        dslContext.deleteFrom(Cars.CARS)
                .where(Cars.CARS.ID.eq(id))
                .execute();
    }

    @Override
    public void deleteByOwner(UUID ownerId) {
        dslContext.deleteFrom(Cars.CARS)
                .where(Cars.CARS.OWNER_ID.eq(ownerId))
                .execute();
    }
}
