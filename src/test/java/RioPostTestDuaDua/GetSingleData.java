package RioPostTestDuaDua;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetSingleData {
    String singlelist = "https://mern-backend-8881.herokuapp.com/products/63821f34261319425336fb65/";

    @Test
    public void testStatusCode() {
        Response response = RestAssured.get(singlelist);
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int actual = response.getStatusCode();
        Assert.assertEquals(actual, 200);
    }
    @Test
    public void testValidasiGetSingle() {
        given()
                .get(singlelist)
                .then()
                .statusCode(200)
                .body("name", Matchers.equalTo("PostTest21"))
                .body("category", Matchers.equalTo("katalon"))
                .body("price", Matchers.equalTo(3000));
    }
}
