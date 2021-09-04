package contexts;

public class TestContext {
    private final ScenarioContext scenarioContext;

    public TestContext() {
        scenarioContext = new ScenarioContext();
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
