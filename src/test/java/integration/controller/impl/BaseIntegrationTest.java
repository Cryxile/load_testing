package integration.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zuzex.education.CityManagementApplication;
import com.zuzex.education.mapper.CarMapper;
import com.zuzex.education.repository.CarRepository;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static io.zonky.test.db.AutoConfigureEmbeddedDatabase.DatabaseProvider.ZONKY;

@SpringBootTest(classes = CityManagementApplication.class)
@AutoConfigureMockMvc
@AutoConfigureEmbeddedDatabase(provider = ZONKY, type = AutoConfigureEmbeddedDatabase.DatabaseType.POSTGRES)
public abstract class BaseIntegrationTest {
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected CarRepository carRepository;
    @Autowired
    protected CarMapper carMapper;
    @Autowired
    protected ObjectMapper objectMapper;
}
