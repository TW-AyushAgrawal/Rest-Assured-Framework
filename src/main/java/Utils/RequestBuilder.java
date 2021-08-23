package Utils;

import contexts.TestContext;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RequestBuilder {
    private Object requestObject;
    private TestContext testContext;
    private String endPoint;

}
