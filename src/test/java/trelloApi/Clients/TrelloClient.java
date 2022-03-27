package trelloApi.Clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import trelloApi.helpers.TestCaseContext;

import static trelloApi.constants.ProjectConstants.*;

public class TrelloClient {
    public static Response getBoardInfo(){
        return RestAssured
                .given().log().all()
                .param("key", API_KEY)
                .param("token", API_TOKEN)
                .when()
                .get("https://api.trello.com/1/boards/" + BOARD_ID)
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }


    public static Response changeBoardName(String name){
        return RestAssured
                .given().log().all()
                .param("key", API_KEY)
                .param("token", API_TOKEN)
                .queryParam("name", name)
                .when()
                .put("https://api.trello.com/1/boards/" + BOARD_ID)
                .then().log().all()
                .statusCode(200)
                .extract().response();

    }

    public static Response createList(String name){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .queryParam("name", name)
                .queryParam("idBoard", BOARD_ID)
                .when()
                .post("https://api.trello.com/1/lists")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response deleteList(){ //archiveList
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .queryParam("closed", true)
                .when()
                .put("https://api.trello.com/1/lists/" + TestCaseContext.getList().getId())
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

}
