package org.example.matb02cucumber.bdd.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExampleCriarUsuariosStepDefinitions {

    @When("o client chama a api")
    public void o_client_chama_a_api() {
        System.out.println("chama a api");
    }

    @And("os dados sao validos")
    public void os_dados_sao_validos() {
        System.out.println("dados validos");
    }

    @Then("o usuario e criado no banco")
    public void o_usuario_e_criado_no_banco() {
        System.out.println("usuario criado");
    }
}
