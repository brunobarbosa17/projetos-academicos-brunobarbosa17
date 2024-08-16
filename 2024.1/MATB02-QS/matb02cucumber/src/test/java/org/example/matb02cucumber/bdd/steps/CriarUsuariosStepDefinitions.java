package org.example.matb02cucumber.bdd.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CriarUsuariosStepDefinitions {

    private final WebApplicationContext webApplicationContext;
    private ResultActions resultActions;


    public CriarUsuariosStepDefinitions(WebApplicationContext webApplicationContext) {
        this.webApplicationContext = webApplicationContext;
    }

    @When("a aplicacao e chamada com payload {string}")
    public void aAplicacaoEChamadaComPayload(String json) throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).addFilter((request, response, chain) -> {
            response.setCharacterEncoding("UTF-8");
            chain.doFilter(request, response);
        }, "/*").build();

//        var body = new CreateUserDTO();
//        body.setEmail("email@email.com");
//        body.setName("name");
//        body.setPassword("password");
//        body.setRegister("register");
//        body.setTypeUser("1");
//        System.out.println(body.toString());
        System.out.println(json);
        resultActions = mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/users/create")
                        .contentType("application/json")
                        //.content("{\"id\":1,\"name\":\"Usuario\",\"email\":\"email@email.com\",\"register\":\"registro\",\"password\":\"123\",\"typeUser\":\"1\"}"))
                        .content(json))
                .andExpect(status().is(200));

    }

    @And("o {string} esta correto")
    public void oEstaCorreto(String email) {
        Assertions.assertEquals("email@email.com", email);
    }

    @Then("o usuario foi criado no banco")
    public void oUsuarioFoiCriadoNoBanco() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).addFilter((request, response, chain) -> {
            response.setCharacterEncoding("UTF-8");
            chain.doFilter(request, response);
        }, "/*").build();

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/users/")
                        .contentType("application/json"))
                .andExpect(result1 -> Assertions.assertTrue(result1.getResponse().getContentAsString().contains("\"name\":\"Usuario\",\"email\":\"email@email.com\",\"register\":\"registro\",\"password\":\"123\",\"typeUser\":\"1\"}")));


    }

}
