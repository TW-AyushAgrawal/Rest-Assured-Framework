package Utils;

import contexts.TestContext;
import io.restassured.response.Response;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseBuilder {
    private Response response;
    private TestContext testContext;

    public ResponseBuilder(Response response, TestContext testContext){
        this.response = response;
        this.testContext = testContext;
    }
}
