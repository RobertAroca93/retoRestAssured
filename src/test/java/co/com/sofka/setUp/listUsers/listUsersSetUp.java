package co.com.sofka.setUp.listUsers;

import io.restassured.RestAssured;
import org.apache.log4j.PropertyConfigurator;

import static co.com.sofka.util.log4jValues.LOG4J_PROPERTIES_FILE_PATH;

public class listUsersSetUp {

    private static final String BASE_URI ="https://reqres.in";
    private static final String BASE_PATH = "/api";
    protected static final String LIST_SOURCE = "/users?page=2";

    protected void generalStUp(){
        setUpLog4j2();
        setUpBases();

    }

    private void setUpLog4j2() {
        PropertyConfigurator.configure(System.getProperty("user.dir")+ LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

    private void setUpBases() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = BASE_PATH;


    }


}

