package RioPostTestDuaDua;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutData {
    String GetPut = "https://mern-backend-8881.herokuapp.com/products/63821f34261319425336fb65";

    @Test
    public void testPutProductId() {
        JSONObject request = new JSONObject();
        request.put("_id", "63821f34261319425336fb65");
        request.put("name", "PostTest212");
        request.put("category", "katalonn");
        request.put("price", 3000);
        System.out.println(request.toJSONString());

        RestAssured.given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put(GetPut)
                .then()
                .statusCode(404)
                .log().all();
    }

    @Test
    public void testValidasiPut() {
        RestAssured.given()
                .get(GetPut)
                .then()
                .statusCode(200)
                .body("_id", Matchers.equalTo("63821f34261319425336fb65"))
                .body("name", Matchers.equalTo("PostTest212"))
                .body("category", Matchers.equalTo("katalonn"))
                .body("price", Matchers.equalTo(3000));
    }
}
