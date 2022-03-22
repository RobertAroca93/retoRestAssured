package co.com.sofka.Runners.listUsers;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        glue = {"co.com.sofka.stepDefinitions"},
        features = {"src/test/resources/features/loginSuccessfull.feature"},
        tags = ""

)

public class listUsersTest {
}
