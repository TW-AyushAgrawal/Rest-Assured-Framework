package Utils;

import contexts.TestContext;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestBuilder {
    private Object requestObject;
    private TestContext testContext;
    private String endPoint;

    public RequestBuilder(Object requestObject, TestContext testContext, String endPoint){
        this.requestObject = requestObject;
        this.testContext = testContext;
        this.endPoint = endPoint;
    }
}
