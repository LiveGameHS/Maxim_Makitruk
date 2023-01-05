package StepDefinitions;

import Pojos.DeleteRequest;
import Pojos.GetMetaDataRequest;
import Pojos.UploadRequest;
import Utils.RestWrapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import java.io.File;

public class TestDropboxAPISteps {
    RequestSpecification request_Spec = RestWrapper.request_specification;
    File file = new File("src/test/resources/ACDC.jpg");
    int statusCode;
    RequestSpecification request;

    //Given для всіх cucumber тестів у Background

    @Given("request specification is setted")
    public void set_request_specification() {
        request = RestAssured.given(request_Spec);
    }

    //Перший етап cucumber сценарію : Upload steps 

    @When("Dropbox-API-Arg header is setted")
    public void set_header_dropbox_API_Arg() {
        UploadRequest upload = UploadRequest.builder().path("/Logo.jpg").build();
        request.header("Dropbox-API-Arg", upload);
    }

    @And("header parametre request content has type application/octet-stream")
    public void header_parametre_request_content_has_type_Application_Octet_Stream() {
        request.header("Content-Type", "application/octet-stream");
    }

    @And("request uploading body params is setted")
    public void request_uploading_body_params_is_setted() {
        request.body(file);
    }

    @And("send upload POST request")
    public void send_POST_request() {
        Response response = request.post("/upload");
        statusCode = response.getStatusCode();
        System.out.println(statusCode);
        System.out.println(response.getBody().asPrettyString());
    }

    @Then("received response code is {int}")
    public void received_response_code(int response_code) {
        Assert.assertEquals(response_code, statusCode);
    }

    //Дуругий етап cucumber сценарію : Get metadata (Повтори вище)

    @When("header parametre request content has type application/json")
    public void header_parametre_request_content_has_type_Application_Json() {
        request.header("Content-Type", "application/json");
    }

    @And("request getting metadata body params is setted")
    public void request_getting_metadata_body_params_is_setted() {
        GetMetaDataRequest getMetaDataRequest = GetMetaDataRequest.builder().path("/Logo.jpg").build();
        request.body(getMetaDataRequest);
    }

    @And("send getMetadata POST request")
    public void sendGetMetadataPOSTRequest() {
        Response response = request.post("/get_metadata");
        statusCode = response.getStatusCode();
        System.out.println(statusCode);
        System.out.println(response.getBody().asPrettyString());
    }

    //Третій етап cucumber сценарію : Delete file (Повтори вище)

    @And("set request body params for deleting file is setted")
    public void set_request_body_params_for_deleting_file_setted() {
        DeleteRequest deleteRequest = DeleteRequest.builder().path("/Logo.jpg").build();
        request.body(deleteRequest);
    }

    @And("send delete POST request")
    public void sendDeletePOSTRequest() {
        Response resp = request.post("/delete_v2");
        statusCode = resp.getStatusCode();
        System.out.println(statusCode);
        System.out.println(resp.getBody().asPrettyString());
    }
}
