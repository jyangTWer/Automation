package ApiTest;

import com.alibaba.fastjson.JSON;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
//import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetApi {
  @BeforeAll
  private static void baseUrl() {
    RestAssured.baseURI = "https://petstore.swagger.io/v2";
  }

  @Test
  @DisplayName("Get pets by status")
  @Tag("IntegerationTest")
  @Tag("Smoke12")
  public void GetPets() {
    Response response = given().
            header("Accept", "application/json").
            param("status", "available").
    when().
            get("/pet/findByStatus");

    List<Map<String, Object>> pets = response.body().as(new TypeRef<>() {
    });
    assertThat(pets.size(), greaterThan(187));
  }

  @Test
  @DisplayName("Get pet by id")
  @Tag("Smoke")
  public void GetPet() {
    given().
        header("Accept", "application/json").
    when().
        get("/pet/111222333").
    then().
        body("category.name", equalTo("maomao"));
  }

  @Test
  @DisplayName("post pet")
  @Tag("Smoke")
  public void AddNewPet() {
    String body = "{\"id\":111222333,\"category\":{\"id\":0,\"name\":\"maomao\"},\"name\":\"doggie\",\"photoUrls\":[\"https://ichef.bbci.co.uk/news/660/cpsprodpb/AAE7/production/_111515734_gettyimages-1208779325.jpg\"],\"tags\":[{\"id\":0,\"name\":\"Sweet\"}],\"status\":\"available\"}";

    given().
            header("Content-Type", "application/json").
            header("accept", "application/json").
            body(body).
    when().
            post("/pet").
    then().
            statusCode(200).
            body("category.name", equalTo("maomao"));
  }

  @Test
  @DisplayName("post pet by hashMap")
  @Tag("Smoke")
  public void AddNewPetAgain() {
    Map<String, Object> jsonAsMap = new HashMap<>();
    jsonAsMap.put("id", "111222334");
    jsonAsMap.put("status", "available");
    jsonAsMap.put("category", new HashMap<String, String>() {{
      put("id", "0");
      put("name", "maomao");
    }});
    jsonAsMap.put("name", "doggie");
    jsonAsMap.put("photoUrls", new String[]{"\"https://ichef.bbci.co.uk/news/660/cpsprodpb/AAE7/production/_111515734_gettyimages-1208779325.jpg\""});
    jsonAsMap.put("tags", Arrays.asList(new HashMap<String, String>() {{
      put("id", "0");
      put("name", "Sweet");
    }}));

    given().
        header("Content-Type", "application/json").
        header("accept", "application/json").
        body(JSON.toJSONString(jsonAsMap)).
    when().
        post("/pet").
    then().
        statusCode(200).
        body("category.name", equalTo("maomao"));
  }

  @Test
  @DisplayName("Delete pet by id")
  @Tag("Smoke12")
  @Tag("Smoke")
  public void DeletePet() {
    given().
            header("accept", "application/json").
            pathParam("petid", "111222334").
    when().
            post("/pet/{petid}").
    then().
            statusCode(200).
            body("message", equalTo("111222334"));
  }
}
