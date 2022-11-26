package PostTestDuaDua;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PatchData {
    String GetPatch = "https://mern-backend-8881.herokuapp.com/products/63821f34261319425336fb65";

    @Test
    public void Patch() {
        JSONObject request = new JSONObject();
        request.put("_id", "63821f34261319425336fb65");
        request.put("name", "PostTest212");
        request.put("category", "katalonn");
        request.put("price", 3000);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("https://mern-backend-8881.herokuapp.com/products/63821f34261319425336fb65")
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void testValidasiPatch() {
        given()
                .get(GetPatch)
                .then()
                .statusCode(200)
                .body("_id", equalTo("63821f34261319425336fb65"))
                .body("name", equalTo("PostTest212"))
                .body("category", equalTo("katalonn"))
                .body("price", equalTo(3000));
    }

}
