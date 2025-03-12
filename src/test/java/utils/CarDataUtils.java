package utils;

import com.zuzex.education.model.db.Car;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CarDataUtils {

    public static List<Car> getDefaultCars() {
        return List.of(
                Car.builder()
                        .id(UUID.fromString("521e5e92-1ff0-4890-bcf9-37643f50983a"))
                        .brand("BMW")
                        .model("X6")
                        .color("Black")
                        .ownerId(UUID.fromString("23f099dd-fcf7-4c3b-a5cf-eaf6168b228e"))
                        .build(),
                Car.builder()
                        .id(UUID.fromString("34334c9f-86c9-4625-9506-40fbeb61ecf4"))
                        .brand("BMW")
                        .model("X7")
                        .color("White")
                        .ownerId(UUID.fromString("75aad12d-c1b6-4869-82e2-e89cc6e6ee31"))
                        .build(),
                Car.builder()
                        .id(UUID.fromString("7b9f172f-ad70-42d4-8070-8f8197d31b3a"))
                        .brand("Renault")
                        .model("Logan")
                        .color("White")
                        .ownerId(UUID.fromString("75aad12d-c1b6-4869-82e2-e89cc6e6ee31"))
                        .build());
    }

    public static List<Car> getDefaultCars(UUID ownerId) {
        return List.of(
                Car.builder()
                        .id(UUID.fromString("521e5e92-1ff0-4890-bcf9-37643f50983a"))
                        .brand("BMW")
                        .model("X6")
                        .color("Black")
                        .ownerId(ownerId)
                        .build(),
                Car.builder()
                        .id(UUID.fromString("b6e22c94-1ffb-4703-b58b-086c86b01852"))
                        .brand("Renault")
                        .model("Megan")
                        .color("White")
                        .ownerId(ownerId)
                        .build()
        );
    }

    public static Car getDefaultCar() {
        return Car.builder()
                .id(UUID.fromString("521e5e92-1ff0-4890-bcf9-37643f50983a"))
                .brand("BMW")
                .model("X6")
                .color("Black")
                .ownerId(UUID.fromString("23f099dd-fcf7-4c3b-a5cf-eaf6168b228e"))
                .build();
    }

}
