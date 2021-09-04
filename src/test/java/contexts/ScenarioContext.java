package contexts;

import enums.APIResources;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private final Map<String, Object> scenarioContext;

    public ScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    public void setContext(APIResources key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(APIResources key) {
        return scenarioContext.get(key.toString());
    }
}
