package commons;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RequestGenerator {

    public Response postMessage(String url, Map headers, String jsonRequest) {
        Response response = given().headers(headers).body(jsonRequest).when().post(url).then().contentType(ContentType.JSON).extract().response();
        return response;
    }

    public Response getMessage(String url, Map headers) {
        Response response = given().headers(headers).when().get(url).then().contentType(ContentType.JSON).extract().response();
        return response;
    }

    public Response putMessage(String url, Map headers, String jsonRequest) {
        Response response = given().headers(headers).body(jsonRequest).when().put(url).then().contentType(ContentType.JSON).extract().response();
        return response;
    }

    public Response deleteMessage(String url, Map headers, String jsonRequest) {
        Response response = given().headers(headers).body(jsonRequest).when().delete(url).then().contentType(ContentType.JSON).extract().response();
        return response;
    }


    /**
     * Call Get method to get Response
     */
    @Test
    public void callGetMethod(){
        RequestGenerator requestGenerator = new RequestGenerator();
        Map<String, String> headers = new HashMap();
        headers.put("Accept","application/json");
        headers.put("Content-Type","application/json");
        Response response = requestGenerator.getMessage("http://httpbin.org/get",headers);
        //Response response = requestGenerator.getMessage("https://jsonplaceholder.typicode.com/todos/1",headers);
        System.out.println("RESPONSE CODE: " + response.statusCode());
        System.out.println("RESPONSE MESSAGE: " + response.asString());
    }

    /*
     *CALL POST Method to get Response from server
     */

    @Test
    public void callPostMethod(){
        RequestGenerator requestGenerator = new RequestGenerator();
        Map<String, String> headers = new HashMap();
        headers.put("Accept","application/json");
        headers.put("Content-Type","application/json");
        Response response = requestGenerator.postMessage("https://jsonplaceholder.typicode.com/todos/1",headers,"");
        System.out.println("RESPONSE CODE: " + response.statusCode());
        System.out.println("RESPONSE MESSAGE: " + response.asString());
    }

}
