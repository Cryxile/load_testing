package unit.service.impl;

import com.zuzex.education.exception.CarNotFoundException;
import com.zuzex.education.model.db.Car;
import com.zuzex.education.repository.hibernate.CarHibernateRepository;
import com.zuzex.education.service.impl.CarServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.CarDataUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Модульное тестирование CarService с hibernate-реализацией репозитория")
@ExtendWith(MockitoExtension.class)
class CarServiceImplHibernateTest {
    @InjectMocks
    CarServiceImpl carService;
    @Mock
    CarHibernateRepository carRepository;

    @Test
    @DisplayName("Получение всех машин из БД")
    void should_return_all_cars() {
        //given
        List<Car> inputCars = CarDataUtils.getDefaultCars();
        when(carRepository.findAll()).thenReturn(inputCars);

        //when
        List<Car> cars = carService.findAll();

        //then
        assertEquals(inputCars.size(), cars.size());
        inputCars.forEach(car -> assertTrue(cars.contains(car)));
    }

    @Test
    @DisplayName("Получение машины по идентификатору владельца")
    void should_return_all_cars_belong_to_owner() {
        //given
        UUID ownerId = UUID.fromString("75aad12d-c1b6-4869-82e2-e89cc6e6ee31");
        List<Car> inputCars = CarDataUtils.getDefaultCars(ownerId);
        when(carRepository.findAllByOwner(ownerId)).thenReturn(inputCars);

        //when
        List<Car> ownerCars = carService.findAllByOwner(ownerId);

        //then
        assertEquals(inputCars.size(), ownerCars.size());
        inputCars.forEach(car -> assertTrue(ownerCars.contains(car)));
    }

    @Test
    @DisplayName("Получение машины по её идентификатору")
    void should_return_car_when_exists() {
        //given
        UUID carId = UUID.fromString("521e5e92-1ff0-4890-bcf9-37643f50983a");
        Car expected = CarDataUtils.getDefaultCar();
        when(carRepository.findById(carId)).thenReturn(Optional.of(expected));

        //when
        Car result = carService.get(carId);

        //then
        assertEquals(expected.getId(), result.getId());
    }

    @Test
    @DisplayName("Выброс исключения при попытке получить несуществующую машину")
    void should_throw_CarNotFoundException() {
        //given
        UUID carId = UUID.fromString("521e5e92-1ff0-4890-bcf9-37643f50983a");
        when(carRepository.findById(carId)).thenReturn(Optional.empty());

        //expected
        CarNotFoundException exception = assertThrows(CarNotFoundException.class, () -> carService.get(carId));
        assertEquals("Car with such ID (" + carId + ") not exist in the table", exception.getMessage());
    }

    @Test
    @DisplayName("Сохранение машины в БД")
    void should_create_and_return_car() {
        //given
        UUID fixedCarId = UUID.fromString("f48ed694-b311-4d0f-bc98-2fd9b0571a83");
        Car carToSave = CarDataUtils.getDefaultCar().toBuilder().id(fixedCarId).build();
        try (MockedStatic<UUID> mockedUuid = Mockito.mockStatic(UUID.class);
             MockedStatic<Car> mockedCar = Mockito.mockStatic(Car.class)) {
            mockedUuid.when(UUID::randomUUID).thenReturn(fixedCarId);

            Car.CarBuilder builderMock = Mockito.mock(Car.CarBuilder.class);
            mockedCar.when(Car::builder).thenReturn(builderMock);
            when(builderMock.id(carToSave.getId())).thenReturn(builderMock);
            when(builderMock.brand(carToSave.getBrand())).thenReturn(builderMock);
            when(builderMock.model(carToSave.getModel())).thenReturn(builderMock);
            when(builderMock.color(carToSave.getColor())).thenReturn(builderMock);
            when(builderMock.ownerId(carToSave.getOwnerId())).thenReturn(builderMock);
            when(builderMock.build()).thenReturn(carToSave);

            when(carRepository.save(carToSave)).thenReturn(carToSave);

            //when
            Car createdCar = carService.create(carToSave);

            //then
            assertNotNull(createdCar.getId());
            assertEquals(carToSave.getId(), createdCar.getId());
            assertEquals(carToSave.getBrand(), createdCar.getBrand());
            assertEquals(carToSave.getModel(), createdCar.getModel());
            assertEquals(carToSave.getColor(), createdCar.getColor());
            assertEquals(carToSave.getOwnerId(), createdCar.getOwnerId());
        }
    }

    @Test
    @DisplayName("Обновление машины в БД")
    void should_update_and_return_car() {
        //given
        Car inputCar = CarDataUtils.getDefaultCar().toBuilder().color("White").build();
        when(carRepository.save(inputCar)).thenReturn(inputCar);

        //when
        Car updatedCar = carService.update(inputCar);

        //then
        assertEquals(inputCar.getId(), updatedCar.getId());
        assertEquals(inputCar.getBrand(), updatedCar.getBrand());
        assertEquals(inputCar.getModel(), updatedCar.getModel());
        assertEquals(inputCar.getColor(), updatedCar.getColor());
        assertEquals(inputCar.getOwnerId(), updatedCar.getOwnerId());
    }

    @Test
    @DisplayName("Удаление машины из БД по её идентификатору")
    void should_delete_car() {
        //given
        UUID carId = UUID.fromString("34334c9f-86c9-4625-9506-40fbeb61ecf4");
        doNothing().when(carRepository).deleteById(carId);

        //when
        carService.delete(carId);

        //then
        verify(carRepository, times(1)).deleteById(carId);
    }

    @Test
    @DisplayName("Удаление машины из БД по идентификатору владельца")
    void should_delete_car_by_owner_id() {
        //given
        UUID ownerId = UUID.fromString("23f099dd-fcf7-4c3b-a5cf-eaf6168b228e");
        doNothing().when(carRepository).deleteByOwner(ownerId);

        //when
        carService.deleteByOwner(ownerId);

        //then
        verify(carRepository, times(1)).deleteByOwner(ownerId);
    }
}
