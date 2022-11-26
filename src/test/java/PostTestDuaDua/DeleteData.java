package PostTestDuaDua;

import org.testng.annotations.Test;
import static  io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class DeleteData {
    String DelData = "https://mern-backend-8881.herokuapp.com/products/63821f34261319425336fb65";

    @Test
    public void testDel(){
        when()
                .delete(DelData)
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public void validtestDel(){
        given()
                .get(DelData)
                .then()
                .statusCode(200);
    }

}
