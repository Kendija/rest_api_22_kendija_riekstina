package clickupApi.clients;

import clickupApi.helpers.TestCaseContext;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static clickupApi.constants.ProjectConstants.*;

public class ClickupClient {
    public static Response getSpace(){
        return RestAssured
                .given().log().all()
                .header("Authorization", API_TOKEN)
                .when()
                .get("https://api.clickup.com/api/v2/space/" + SPACE_ID)
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response CreateFolder(String name, JSONObject obj){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .queryParam("name", name)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/space/" + SPACE_ID + "/folder")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response CreateList(String name, JSONObject obj){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .queryParam("name", name)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/folder/" + TestCaseContext.getFolder().getId() + "/list")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response createTaskInList(String name, JSONObject obj){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .queryParam("name", name)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/list/"+ TestCaseContext.getList().getId() + "/task")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response deleteTask(String name, JSONObject obj){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .queryParam("name", name)
                .body(obj)
                .when()
                .delete("https://api.clickup.com/api/v2/task/" + TestCaseContext.getTask().getId())
                .then().log().all()
                .statusCode(204) //uztaisīju šādi, jo tasks tika izdzēsts un response nebija ko atgriezt
                                    // nezināju kā to apiet citādāk
                .extract().response();
    }
    public static Response deleteFolder(JSONObject obj){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .body(obj)
                .when()
                .delete("https://api.clickup.com/api/v2/folder/" + TestCaseContext.getFolder().getId())
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
}
