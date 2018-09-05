package stepDef;

import commons.RequestGenerator;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class restStepDef {
        private static RequestGenerator requestGenerator = new RequestGenerator();

    @Given("^user calls the web service$")
    public void user_calls_the_web_service() throws Throwable {
        Map<String, String> headers = new HashMap();
        headers.put("Accept","application/json");
        headers.put("Content-Type","application/json");
        Response response = requestGenerator.getMessage("http://httpbin.org/get",headers);
        //Response response = requestGenerator.getMessage("https://jsonplaceholder.typicode.com/todos/1",headers);
        System.out.println("RESPONSE CODE: " + response.statusCode());
        System.out.println("RESPONSE MESSAGE: " + response.asString());
    }

    @Then("^user gets the response$")
    public void user_gets_the_response() throws Throwable {

    }

    @And("^user gets th response code as \"([^\"]*)\"$")
    public void user_gets_th_response_code_as(String arg1) throws Throwable {

    }

}
