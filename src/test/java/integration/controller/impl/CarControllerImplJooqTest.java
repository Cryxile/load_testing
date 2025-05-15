package integration.controller.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(value = {"test", "jooq"})
@DisplayName("Интеграционное тестирование CarControllerImpl с jooq-реализацией репозитория")
class CarControllerImplJooqTest extends CarControllerImplTest {
    @Test
    @DisplayName("Получение всех машин из БД")
    protected void should_return_all_cars() throws Exception {
        super.should_return_all_cars();
    }

    @Test
    @DisplayName("Получение машины по идентификатору владельца")
    protected void should_return_all_cars_belong_to_owner() throws Exception {
        super.should_return_all_cars_belong_to_owner();
    }

    @Test
    @DisplayName("Получение машины по её идентификатору")
    protected void should_return_car_when_exists() throws Exception {
        super.should_return_car_when_exists();
    }

    @Test
    @DisplayName("Вывод сообщения об ошибке и статус кода при попытке получить несуществующую машину")
    protected void should_respond_not_found_status_and_message() throws Exception {
        super.should_respond_not_found_status_and_message();
    }

    @Test
    @DisplayName("Сохранение машины в БД")
    protected void should_create_and_return_car() throws Exception {
        super.should_create_and_return_car();
    }

    @Test
    @DisplayName("Обновление машины в БД")
    protected void should_update_and_return_car() throws Exception {
        super.should_update_and_return_car();
    }

    @Test
    @DisplayName("Удаление машины из БД")
    protected void should_delete_car_and_return_no_content() throws Exception {
        super.should_delete_car_and_return_no_content();
    }
}
