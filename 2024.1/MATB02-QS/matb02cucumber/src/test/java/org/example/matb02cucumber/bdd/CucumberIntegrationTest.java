package org.example.matb02cucumber.bdd;

import io.cucumber.core.cli.Main;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CucumberIntegrationTest extends SpringIntegrationTest {
    public static final int SUCCESS_EXIT_STATUS = 0;

    @ParameterizedTest
    @ValueSource(strings = {
            "criar-usuario.feature",
    })
    public void runCucumberTest(String file) {
        byte exitstatus = 0;
        try {
            String[] argv = new String[]{"-g", "", "./src/test/resources/features/" + file};
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            exitstatus = Main.run(argv, contextClassLoader);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        assertEquals(SUCCESS_EXIT_STATUS, exitstatus);//NOSONAR
    }
}
