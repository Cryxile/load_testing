package integration.controller.impl;

import com.zuzex.education.dto.ErrorDTO;
import com.zuzex.education.dto.car.CarDTO;
import com.zuzex.education.dto.car.CreateCarRq;
import com.zuzex.education.dto.car.FindCarsRs;
import com.zuzex.education.model.db.Car;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;
import java.util.UUID;

import static com.zuzex.education.constants.ResourceConstants.CARS_RESOURCE;
import static com.zuzex.education.constants.ResourceConstants.RESOURCE_VERSION_V1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

abstract class CarControllerImplTest extends BaseIntegrationTest {
    protected void should_return_all_cars() throws Exception {
        //given
        carRepository.save(
                Car.builder()
                        .id(UUID.randomUUID())
                        .brand("Kia")
                        .model("Rio")
                        .color("Yellow")
                        .ownerId(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"))
                        .build()
        );
        carRepository.save(
                Car.builder()
                        .id(UUID.randomUUID())
                        .brand("Lada")
                        .model("Vesta")
                        .color("Black")
                        .ownerId(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"))
                        .build()
        );
        FindCarsRs cars = carMapper.map(carRepository.findAll());

        //when
        ResultActions resultActions = mockMvc.perform(
                get(RESOURCE_VERSION_V1 + CARS_RESOURCE)
        );

        //then
        String response = resultActions
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        FindCarsRs responseCars = objectMapper.readValue(response, FindCarsRs.class);
        assertEquals(cars.getCars().size(), responseCars.getCars().size());
        cars.getCars().forEach(
                car -> assertTrue(responseCars.getCars().stream()
                        .anyMatch(responseCar -> responseCar.getId().equals(car.getId())))
        );
    }

    protected void should_return_all_cars_belong_to_owner() throws Exception {
        //given
        carRepository.save(
                Car.builder()
                        .id(UUID.randomUUID())
                        .brand("Honda")
                        .model("CRV")
                        .color("Red")
                        .ownerId(UUID.fromString("550e8400-e29b-41d4-a716-446655440003"))
                        .build()
        );
        carRepository.save(
                Car.builder()
                        .id(UUID.randomUUID())
                        .brand("Nissan")
                        .model("X-Trail")
                        .color("Blue")
                        .ownerId(UUID.fromString("550e8400-e29b-41d4-a716-446655440003"))
                        .build()
        );
        UUID ownerId = UUID.fromString("550e8400-e29b-41d4-a716-446655440003");
        List<Car> ownerCars = carRepository.findAllByOwner(ownerId);

        //when
        ResultActions resultActions = mockMvc.perform(
                get(RESOURCE_VERSION_V1 + CARS_RESOURCE + "/owner/{ownerId}", ownerId)
        );

        //then
        String response = resultActions
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        FindCarsRs responseCars = objectMapper.readValue(response, FindCarsRs.class);
        assertEquals(ownerCars.size(), responseCars.getCars().size());
        ownerCars.forEach(
                car -> assertTrue(responseCars.getCars().stream()
                        .anyMatch(responseCar -> responseCar.getId().equals(car.getId())))
        );
    }


    protected void should_return_car_when_exists() throws Exception {
        //given
        UUID id = UUID.fromString("550e8400-e29b-41d4-a716-446655440002");

        //when
        ResultActions resultActions = mockMvc.perform(
                get(RESOURCE_VERSION_V1 + CARS_RESOURCE + "/{id}", id)
        );

        //then
        String response = resultActions
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        CarDTO responseCar = objectMapper.readValue(response, CarDTO.class);
        assertEquals(id, responseCar.getId());
    }

    protected void should_respond_not_found_status_and_message() throws Exception {
        //given
        UUID id = UUID.fromString("550e8400-e29b-41d4-a716-112233445566");

        //when
        ResultActions resultActions = mockMvc.perform(
                get(RESOURCE_VERSION_V1 + CARS_RESOURCE + "/{id}", id)
        );

        //then
        String response = resultActions
                .andExpect(status().isNotFound())
                .andReturn()
                .getResponse()
                .getContentAsString();
        ErrorDTO errorResponse = objectMapper.readValue(response, ErrorDTO.class);
        assertEquals(HttpStatus.NOT_FOUND.value(), errorResponse.getStatus());
        assertFalse(errorResponse.getMessage().isBlank());
    }

    protected void should_create_and_return_car() throws Exception {
        //given
        CreateCarRq inputCar = CreateCarRq.builder()
                .brand("Lada")
                .model("Vesta")
                .color("Grey")
                .ownerId(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"))
                .build();
        String requestJson = objectMapper.writeValueAsString(inputCar);

        //when
        ResultActions resultActions = mockMvc.perform(post(RESOURCE_VERSION_V1 + CARS_RESOURCE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)
        );

        //then
        String response = resultActions
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
        CarDTO responseCar = objectMapper.readValue(response, CarDTO.class);
        assertNotNull(responseCar.getId());
        assertEquals(inputCar.getBrand(), responseCar.getBrand());
        assertEquals(inputCar.getModel(), responseCar.getModel());
        assertEquals(inputCar.getColor(), responseCar.getColor());
        assertEquals(inputCar.getOwnerId(), responseCar.getOwnerId());
    }

    protected void should_update_and_return_car() throws Exception {
        //given
        Car inputCar = Car.builder()
                .id(UUID.fromString("550e8400-e29b-41d4-a716-446655440001"))
                .brand("Toyota")
                .model("Camry")
                .color("Yellow")
                .ownerId(UUID.fromString("550e8400-e29b-41d4-a716-446655440003"))
                .build();
        String requestJson = objectMapper.writeValueAsString(inputCar);

        //when
        ResultActions resultActions = mockMvc.perform(
                put(RESOURCE_VERSION_V1 + CARS_RESOURCE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        );

        //then
        String response = resultActions
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        CarDTO responseCar = objectMapper.readValue(response, CarDTO.class);
        assertEquals(inputCar.getId(), responseCar.getId());
        assertEquals(inputCar.getBrand(), responseCar.getBrand());
        assertEquals(inputCar.getModel(), responseCar.getModel());
        assertEquals(inputCar.getColor(), responseCar.getColor());
        assertEquals(inputCar.getOwnerId(), responseCar.getOwnerId());
    }

    protected void should_delete_car_and_return_no_content() throws Exception {
        //given
        Car carToDelete = carRepository.save(
                Car.builder()
                        .id(UUID.fromString("550e8400-e29b-41d4-a716-446655441133"))
                        .brand("Renault")
                        .model("Scenic")
                        .color("Grey")
                        .ownerId(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"))
                        .build());

        //when
        ResultActions resultActions = mockMvc.perform(
                delete(RESOURCE_VERSION_V1 + CARS_RESOURCE + "/{id}", carToDelete.getId())
        );

        //then
        resultActions.andExpect(status().isNoContent());
        assertFalse(carRepository.findById(carToDelete.getId()).isPresent());
    }
}
