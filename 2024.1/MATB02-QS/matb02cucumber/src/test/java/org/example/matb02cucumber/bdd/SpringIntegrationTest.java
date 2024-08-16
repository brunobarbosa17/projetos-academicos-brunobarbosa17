package org.example.matb02cucumber.bdd;

import io.cucumber.spring.CucumberContextConfiguration;
import org.example.matb02cucumber.Matb02cucumberApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = Matb02cucumberApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringIntegrationTest {
}
