package Utils;

import contexts.TestContext;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ResponseBuilder {
    private Response response;
    private TestContext testContext;

}
