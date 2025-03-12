package integration.controller.impl;

import org.junit.jupiter.api.DisplayName;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(value = {"test", "jooq"})
@DisplayName("Интеграционное тестирование CarControllerImpl с jooq-реализацией репозитория")
class CarControllerImplJooqTest extends CarControllerImplTest {
}
