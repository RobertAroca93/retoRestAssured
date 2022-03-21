package co.com.sofka.stepDefinitions.listUsers;

import co.com.sofka.setUp.listUsers.listUsersSetUp;
import co.com.sofka.stepDefinitions.login.loginSuccessfullStepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class listUsersStepDefinition extends listUsersSetUp {

    public static final Logger LOGGER= Logger.getLogger(listUsersStepDefinition.class);
    private Response response;
    private RequestSpecification request;

    @Given("dado que o requiero consultar la lista de usuarios")
    public void dado_que_o_requiero_consultar_la_lista_de_usuarios() {
        try {
            generalStUp();

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }
    @When("hago la peticion")
    public void hago_la_peticion() {
        try {
            response = when().get(LIST_SOURCE);

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }
    @Then("el sistema debe generar un codigo de respuesta")
    public void el_sistema_debe_generar_un_codigo_de_respuesta() {
        try {
            response.then().statusCode(HttpStatus.SC_OK).body("data.id", equalTo(2));

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }

}
