package ApiTest;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.basic;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.junit.jupiter.api.*;

public class ApiTest {
  @BeforeAll
  private static void baseUrl() {
    RestAssured.baseURI = "baseurl";
    RestAssured.authentication = basic("username", "password");
  }

  @Test
  @DisplayName("Normal API")
  public void normalTest() {
    given().
        param("version", "3.5.0").
        param("platform", "android").
    when().
        get("/api/reading/index").
    then().
        body("data.essay.content_id", hasItems("4340", "4337"));
  }

  @Test
  @DisplayName("pathParam")
  @Tag("Smoke1")
  public void pathParam() {
    given().
        pathParam("essayId", 3395).
        param("version", "3.5.0").
        param("platform", "android").
    when().
        get("/api/comment/praiseandtime/essay/{essayId}/0").
    then().
        body("data.count", equalTo(621));
  }

  @Test
  @DisplayName("header")
  @Tag("Smoke")
  public void header() {
    given().
            header("Accept", "application/json").
            param("version", "3.5.0").
            param("platform", "android").
    when().
            get("/api/comment/praiseandtime/essay/3395/0").
    then().
            assertThat().
            body("data.count", equalTo(621));
  }
}
