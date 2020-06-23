package ApiTest;

import com.alibaba.fastjson.JSON;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

//import static org.hamcrest.MatcherAssert.assertThat;

public class StoreApi {
  @BeforeAll
  private static void baseUrl() {
    RestAssured.baseURI = "https://petstore.swagger.io/v2";
  }

  @Test
  @DisplayName("Find purchase order by ID")
  @Tag("Smoke")
  void FindPetById(){
    given()
            .header("accept", "application/json")
    .when()
            .get("/store/order/5")
    .then()
            .statusCode(200)
            .body("id", equalTo(5));
  }
}