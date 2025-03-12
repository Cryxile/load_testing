package integration.controller.impl;

import org.junit.jupiter.api.DisplayName;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(value = {"test", "hibernate"})
@DisplayName("Интеграционное тестирование CarControllerImpl с hibernate-реализацией репозитория")
class CarControllerImplHibernateTest extends CarControllerImplTest {
}
