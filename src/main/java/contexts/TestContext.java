package contexts;

public class TestContext {
    private static ScenarioContext scenarioContext;

    public TestContext(){
        scenarioContext = new ScenarioContext();
    }

    public static ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
