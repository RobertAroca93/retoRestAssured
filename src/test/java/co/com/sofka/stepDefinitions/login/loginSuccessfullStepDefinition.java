package co.com.sofka.stepDefinitions.login;

import co.com.sofka.setUp.loginSuccessfull.loginSuccessfullSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;


public class loginSuccessfullStepDefinition extends loginSuccessfullSetUp {

    public static final Logger LOGGER = Logger.getLogger(loginSuccessfullStepDefinition.class);
    private Response response;
    private RequestSpecification request;


    @Given("dado que me encuentro en el login, ingreso el email {string} y el password {string}")
    public void dado_que_me_encuentro_en_el_login_ingreso_el_email_y_el_password(String email, String password) {
        try {
            generalStUp();
            request = given().contentType(ContentType.JSON).body(body(email, password));


        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }


    }
    @When("estoy en el modulo de login")
    public void estoy_en_el_modulo_de_login() {
        try {
            response = request.when().post(LOGIN_SOURCE);
        }catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }
    @Then("el sistema debe generar el codigo de respuesta")
    public void el_sistema_debe_generar_el_codigo_de_respuesta() {

        try {
            response.then().statusCode(HttpStatus.SC_OK).body("token", notNullValue());
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }
    private String body (String email, String password){
        return "{\n" + "\"email\": \"" + email + "\",\n" + "\"password\": \"" + password + "\"\n" + "}";

    }


}
